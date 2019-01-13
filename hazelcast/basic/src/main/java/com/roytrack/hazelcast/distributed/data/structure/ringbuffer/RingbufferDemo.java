package com.roytrack.hazelcast.distributed.data.structure.ringbuffer;

import java.util.HashMap;
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

public class RingbufferDemo {
  public static void main(String[] args) {
    Config config = new Config();
    RingbufferConfig ringbufferConfig = new RingbufferConfig();
    ringbufferConfig.setCapacity(100);
    ringbufferConfig.setName("rb");
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
        item = ringbuffer.readOne(sequence);
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      sequence++;
      System.out.println(item + " headSequence is " + ringbuffer.headSequence()
          + " tailSequence is " + ringbuffer.tailSequence() + " remain capacity is " + ringbuffer.remainingCapacity());


    }
  }

  public static void sampleRingbufferProducer(HazelcastInstance instance) {
    Ringbuffer<String> ringbuffer = instance.getRingbuffer("rb");
    int i = 0;
    while (true) {
      ringbuffer.add("rb" + (i++));
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
        System.out.println(i + " add result is position " + result);
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
        System.out.println("ringbuffer put in " + i);
        Thread.sleep(10L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}


