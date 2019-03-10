package com.roytrack.hazelcast.distributed.data.structure.map;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IExecutorService;
import com.hazelcast.transaction.TransactionContext;
import com.hazelcast.transaction.TransactionOptions;
import com.roytrack.hazelcast.distributed.compute.MapTask;


public class TransactionMapGetForUpdateDemo {

  private HazelcastInstance instance;

  public static void main(String[] args) {
    TransactionMapGetForUpdateDemo demo = new TransactionMapGetForUpdateDemo();
    demo.setInstance(Hazelcast.newHazelcastInstance());
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    executorService.submit(demo::transactionalUpdateMap);
    executorService.submit(() -> demo.queryMap("roy"));
    executorService.submit(() -> demo.queryMap("roy2"));
    executorService.submit(() -> {
      demo.taskUpdateMap();
    });


  }

  public HazelcastInstance getInstance() {
    return instance;
  }

  public void setInstance(HazelcastInstance instance) {
    this.instance = instance;
    instance.getMap("roytrack").put("roy", "lock");
    instance.getMap("roytrack").put("roy2", "nolock");
  }

  public void queryMap(String key) {
    for (int i = 0; i < 100; i++) {
      Long start = System.currentTimeMillis();
      System.out.println(Thread.currentThread().getName() + " key is " + key + " i is " + i + "  start " + start);
      System.out.println(Thread.currentThread().getName() + " key is " + key + " val is " + instance.getMap("roytrack").get(key));
      System.out.println(Thread.currentThread().getName() + " key is " + key + " i is " + i + "  end " + (System.currentTimeMillis() - start));
      try {
        TimeUnit.MILLISECONDS.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void transactionalUpdateMap() {
    try {
      TransactionOptions options = new TransactionOptions();
      options.setTransactionType(TransactionOptions.TransactionType.ONE_PHASE);
      for (int i = 0; i < 100; i++) {
        TransactionContext context = instance.newTransactionContext(options);
        context.beginTransaction();
        try {
          String value = String.valueOf(context.getMap("roytrack").getForUpdate("roy"));
          Long start = System.currentTimeMillis();
          System.out.println("tx " + Thread.currentThread().getName() + " i is " + i + "  start " + start);
          System.out.println(value);
          context.getMap("roytrack").replace("roy", value, "roy" + i);
          try {
            TimeUnit.SECONDS.sleep(10);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          System.out.println("tx " + Thread.currentThread().getName() + " i is " + i + "  end " + (System.currentTimeMillis() - start));
          context.commitTransaction();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void taskUpdateMap() {
    IExecutorService executorService = instance.getExecutorService("royExecutor");
    for (int i = 0; i < 100; i++) {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      executorService.submit(new MapTask());
    }

  }
}
