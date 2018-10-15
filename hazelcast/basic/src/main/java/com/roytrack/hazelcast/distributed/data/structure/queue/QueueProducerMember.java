package com.roytrack.hazelcast.distributed.data.structure.queue;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

public class QueueProducerMember {
  public static void main(String[] args) throws InterruptedException {
    HazelcastInstance hz = Hazelcast.newHazelcastInstance();
    IQueue<Integer> queue = hz.getQueue("queue");
    for (int i = 0; i < 100; i++) {
      queue.put(i);
      System.out.println("Producing:" + i);
      Thread.sleep(1000);
    }
    queue.put(-1);
    System.out.println("Producing Finished!");
  }
}
