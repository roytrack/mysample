package com.roytrack.hazelcast.distributed.data.structure.semaphore;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.hazelcast.config.Config;
import com.hazelcast.config.SemaphoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.ISemaphore;

import static java.util.concurrent.TimeUnit.MICROSECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ISemaphoreDemo {
  public static void main(String[] args) throws InterruptedException {
    ISemaphoreDemo demo = new ISemaphoreDemo();
    demo.MultiThreadAdd();
  }

  public void MultiThreadAdd() throws InterruptedException {
    Config config = new Config();
    SemaphoreConfig semaphoreConfig = config.getSemaphoreConfig("semaphore");
    semaphoreConfig.setName("semaphore").setBackupCount(1)
        .setInitialPermits(3)
        .setQuorumName("quorumname");
    HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
    ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5,
        60L, TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(10));

    executor.submit(new AddThread(hazelcastInstance));
    MICROSECONDS.sleep(100);
    executor.submit(new AddThread(hazelcastInstance));
    MICROSECONDS.sleep(100);
    executor.submit(new AddThread(hazelcastInstance));
    MICROSECONDS.sleep(100);
    executor.submit(new AddThread(hazelcastInstance));
    MICROSECONDS.sleep(100);
    executor.submit(new AddThread(hazelcastInstance));
  }

  class AddThread implements Runnable {
    private HazelcastInstance hazelcastInstance;

    public AddThread(HazelcastInstance hazelcastInstance) {
      this.hazelcastInstance = hazelcastInstance;
    }

    @Override
    public void run() {
      ISemaphore semaphore = hazelcastInstance.getSemaphore("semaphore");
      IAtomicLong resource = hazelcastInstance.getAtomicLong("resource");
      for (int i = 0; i < 1000; i++) {
        System.out.println(Thread.currentThread().getName() + " At iteration: " + i + ", Active Threads: " + resource.get());
        try {
          System.out.println(Thread.currentThread().getName() + " semaphore left : " + semaphore.availablePermits());
          semaphore.acquire();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          resource.incrementAndGet();
          SECONDS.sleep(1);
          resource.decrementAndGet();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          semaphore.release();
        }
      }
      System.out.println("Finished");

    }
  }
}
