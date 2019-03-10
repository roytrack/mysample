package com.roytrack.hazelcast.distributed.compute;

import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.HazelcastInstanceAware;
import com.hazelcast.transaction.TransactionContext;
import com.hazelcast.transaction.TransactionOptions;

public class MapTask implements Callable, Serializable, HazelcastInstanceAware {

  private transient HazelcastInstance instance;


  @Override
  public void setHazelcastInstance(HazelcastInstance hazelcastInstance) {
    this.instance = hazelcastInstance;
  }

  @Override
  public Object call() throws Exception {
    try {
      TransactionOptions options = new TransactionOptions();
      options.setTransactionType(TransactionOptions.TransactionType.ONE_PHASE);
      TransactionContext context = instance.newTransactionContext(options);
      context.beginTransaction();
      try {
        String value = String.valueOf(context.getMap("roytrack").getForUpdate("roy2"));
        int i = 0;
        if (!value.equals("nolock")) {
          i = Integer.valueOf(value.substring(0, 6));
          i++;
        }
        Long start = System.currentTimeMillis();
        System.out.println("tx " + Thread.currentThread().getName() + " i is " + i + "  start " + start);
        System.out.println(value);
        context.getMap("roytrack").replace("roy2", value, "roy" + i);
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

    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
