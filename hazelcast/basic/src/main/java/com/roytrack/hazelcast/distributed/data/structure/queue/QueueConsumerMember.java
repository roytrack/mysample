package com.roytrack.hazelcast.distributed.data.structure.queue;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

public class QueueConsumerMember {
  public static void main(String[] args) throws InterruptedException {
    HazelcastInstance hz = Hazelcast.newHazelcastInstance();
    IQueue<Integer> queue = hz.getQueue("queue");
    while (true) {
      int item = queue.take();
      System.out.println("Consumed: " + item);
      if (item == -1) {
        queue.put(-1);
        break;
      }
      Thread.sleep(5000);
    }
    System.out.println("Consumer Finished!");
  }
}
