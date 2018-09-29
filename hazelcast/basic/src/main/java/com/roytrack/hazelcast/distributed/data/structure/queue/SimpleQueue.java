package com.roytrack.hazelcast.distributed.data.structure.queue;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

import java.util.concurrent.TimeUnit;


public class SimpleQueue {
  public static void main(String[] args) throws InterruptedException {
    HazelcastInstance hz = Hazelcast.newHazelcastInstance();
    IQueue<String> stringBlockingDeque = hz.getQueue("tasks");
    stringBlockingDeque.put("ss");
    String result = stringBlockingDeque.peek();

    boolean offered = stringBlockingDeque.offer("55", 10, TimeUnit.SECONDS);
    result = stringBlockingDeque.poll(5, TimeUnit.SECONDS);
    if (result != null) {
      System.out.println("get from queue :" + result);
    }


  }
}
