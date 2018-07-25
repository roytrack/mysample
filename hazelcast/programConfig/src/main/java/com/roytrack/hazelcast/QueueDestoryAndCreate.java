package com.roytrack.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

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
    }
}
