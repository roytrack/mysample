package com.roytrack.hazelcast.distributed.data.structure.ringbuffer;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.hazelcast.config.Config;
import com.hazelcast.config.RingbufferConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ICompletableFuture;
import com.hazelcast.ringbuffer.OverflowPolicy;
import com.hazelcast.ringbuffer.Ringbuffer;
import com.hazelcast.ringbuffer.StaleSequenceException;

public class RingbufferDemoV2 {
  public static void main(String[] args) {
    Config config = new Config();
    RingbufferConfig ringbufferConfig = new RingbufferConfig();
    ringbufferConfig.setCapacity(100);
    ringbufferConfig.setName("rb");
    ringbufferConfig.setTimeToLiveSeconds(10);
    HashMap configMap = new HashMap();
    configMap.put("rb", ringbufferConfig);
    config.setRingbufferConfigs(configMap);
    HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
    ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2,
        60L, TimeUnit.SECONDS,
        new ArrayBlockingQueue<>(10));
    executor.submit(() -> sampleRingbufferConsumer(instance));
//    executor.submit(() -> sampleRingbufferProducer(instance));
    executor.submit(() -> sampleRingbufferProducerWithFail(instance));
  }

  public static void sampleRingbufferConsumer(HazelcastInstance instance) {
    Ringbuffer<String> ringbuffer = instance.getRingbuffer("rb");
    long sequence = ringbuffer.headSequence();
    while (true) {
      String item = "";
      try {
        long headSequence = ringbuffer.headSequence();
        long tailSequence = ringbuffer.tailSequence();
        if (headSequence - tailSequence == 1) {
          sequence = headSequence;
          System.out.println(Thread.currentThread().getName() + " ringbuffer is empty move next seq is " + sequence);
          sequence++;
          Thread.sleep(100);
          continue;
        }
        item = ringbuffer.readOne(sequence);
        sequence++;
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (StaleSequenceException e) {
        e.printStackTrace();
        System.out.println(Thread.currentThread().getName() + " old sequence is stale ,old sequence is " + sequence + " , new sequence is " + ringbuffer.headSequence());
        sequence = ringbuffer.headSequence() - 1;
      } catch (IllegalArgumentException e) {
        sequence = ringbuffer.headSequence() - 1;
        System.out.println(Thread.currentThread().getName() + " old sequence is illegal ,old sequence is " + sequence + " , new sequence is " + ringbuffer.headSequence());
      }
      System.out.println(Thread.currentThread().getName() + " " + item + " headSequence is " + ringbuffer.headSequence()
          + " tailSequence is " + ringbuffer.tailSequence() + " nowSeq is " + sequence + " remain capacity is " + ringbuffer.remainingCapacity());


    }
  }

  public static void sampleRingbufferProducer(HazelcastInstance instance) {
    Ringbuffer<String> ringbuffer = instance.getRingbuffer("rb");
    int i = 0;
    while (true) {
      long result = ringbuffer.add("rb" + (i++));
      System.out.println(Thread.currentThread().getName() + " " + i + " add result is position " + result
          + " headSequence is " + ringbuffer.headSequence()
          + " tailSequence is " + ringbuffer.tailSequence());
      if (i > 1000) {
        break;
      }
      printProducerLog(i);
    }
  }


  public static void sampleRingbufferProducerWithFail(HazelcastInstance instance) {
    Ringbuffer<String> ringbuffer = instance.getRingbuffer("rb");
    int i = 0;
    while (true) {
      ICompletableFuture<Long> longICompletableFuture = ringbuffer.addAsync("rb" + (i++), OverflowPolicy.FAIL);
      try {
        Long result = longICompletableFuture.get();
        System.out.println(Thread.currentThread().getName() + " " + i + " add result is position " + result
            + " headSequence is " + ringbuffer.headSequence()
            + " tailSequence is " + ringbuffer.tailSequence());
        if (result.longValue() == -1) {
          long sleepMs = 100;
          Random random = new Random();
          while (true) {
            sleepMs = Long.min(5000L, sleepMs * 2);
            Thread.sleep(random.nextInt((int) sleepMs));
            long retryResult = ringbuffer.addAsync("rb" + i, OverflowPolicy.FAIL).get();
            if (retryResult != -1) {
              System.out.println(Thread.currentThread().getName() + " " + i + " add result  retry is position " + retryResult
                  + " headSequence is " + ringbuffer.headSequence()
                  + " tailSequence is " + ringbuffer.tailSequence());
              break;
            }

          }
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
      if (i > 1000) {
        break;
      }
      printProducerLog(i);
    }
  }

  private static void printProducerLog(int i) {
    if (i % 10 == 0) {
      try {
        System.out.println(Thread.currentThread().getName() + " ringbuffer put in " + i);
        Thread.sleep(10L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}


