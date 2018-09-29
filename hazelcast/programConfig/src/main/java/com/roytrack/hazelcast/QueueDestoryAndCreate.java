package com.roytrack.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;
import com.hazelcast.core.ISemaphore;

public class QueueDestoryAndCreate {
  public static void main(String[] args) {

    HazelcastInstance hazelcastInstance1 = Hazelcast.newHazelcastInstance();
    HazelcastInstance hazelcastInstance2 = Hazelcast.newHazelcastInstance();
    IQueue<String> q1 = hazelcastInstance1.getQueue("q");
    IQueue<String> q2 = hazelcastInstance2.getQueue("q");
    q1.add("foo");
    System.out.println("q1.size: " + q1.size() + "  q2.size: " + q2.size());
    q1.destroy();
    System.out.println("q1.size: " + q1.size() + "  q2.size: " + q2.size());
    q1.add("noo");
    System.out.println("q1.size: " + q1.size() + "  q2.size: " + q2.size());

    ISemaphore s1 = hazelcastInstance1.getSemaphore("s1");
    ISemaphore s2 = hazelcastInstance1.getSemaphore("s2");
    ISemaphore sf1 = hazelcastInstance1.getSemaphore("sf1@foo");
    ISemaphore sf2 = hazelcastInstance1.getSemaphore("sf2@foo");
    System.out.println("s1 partitionkey is " + s1.getPartitionKey());
    System.out.println("s2 partitionkey is " + s2.getPartitionKey());
    System.out.println("sf1 partitionkey is " + sf1.getPartitionKey());
    System.out.println("sf2 partitionkey is " + sf2.getPartitionKey());
    ISemaphore s31 = hazelcastInstance1.getSemaphore("s3@" + s1.getPartitionKey());
    System.out.println("s31 partitionkey is " + s31.getPartitionKey());

  }
}
