package com.roytrack.hazelcast.distributed.data.structure.lock;

import java.time.Instant;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ICondition;
import com.hazelcast.core.ILock;

public class LockDemo {
  private HazelcastInstance instance = Hazelcast.newHazelcastInstance();

  public static void main(String[] args) {
    LockDemo demo = new LockDemo();
    demo.simpleLock();
    demo.tryLock();
    demo.threadLock();
    demo.instance.shutdown();

  }

  private void simpleLock() {
    Lock lock = instance.getLock("roytrack");
    lock.lock();
    try {
      System.out.println("lock logic execute");
    } catch (Exception e) {

    } finally {
      lock.unlock();
    }
  }

  private void tryLock() {
    Lock lock2 = instance.getLock("anotherLock");
    try {
      if (lock2.tryLock(5, TimeUnit.SECONDS)) {
        try {
          System.out.println("lock2 logic execute");
        } catch (Exception e) {

        } finally {
          lock2.unlock();
        }
      } else {
        System.out.println("lock2 get lock failed");
      }
    } catch (InterruptedException e) {
      System.out.println("lock2 lock interrupted");
    }
  }

  private void threadLock() {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2,
        60L, TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(10));
    //生产者
    executor.submit(() -> {

      while (true) {
        ILock lock = instance.getLock("royThreadLock");
        ICondition condition = lock.newCondition("conditionId");
        lock.lock();
        try {
          while (Instant.now().getEpochSecond() % 2 == 0) {
            System.out.println("producer wait");
            condition.await();
          }
          System.out.println("produce...");
          Thread.sleep(100);
          condition.signalAll();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
        }
      }

    });
    //消费者
    executor.submit(() -> {

      while (true) {
        ILock lock = instance.getLock("royThreadLock");
        ICondition condition = lock.newCondition("conditionId");
        lock.lock();
        try {
          while (Instant.now().getEpochSecond() % 2 == 1) {
            System.out.println("consumer wait");
            condition.await();
          }
          System.out.println("consume...");
          Thread.sleep(100);
          condition.signalAll();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          lock.unlock();
        }
      }
    });
    try {
      Thread.sleep(20000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    executor.shutdown();

  }
}
