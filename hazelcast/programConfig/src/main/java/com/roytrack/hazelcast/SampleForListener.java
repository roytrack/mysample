package com.roytrack.hazelcast;

import com.hazelcast.core.*;

import java.util.Collection;

public class SampleForListener implements DistributedObjectListener {
    public static void main(String[] args) {
        SampleForListener sample = new SampleForListener();
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        instance.addDistributedObjectListener(sample);
        Collection<DistributedObject> distributedObjects = instance.getDistributedObjects();
        distributedObjects.stream().forEach(v -> {
            System.out.println("#####" + v.getName());
        });
        ISemaphore semaphore = instance.getSemaphore("f1");
        IQueue queue = instance.getQueue("q1");
        queue.add("sd");
        queue.add("sd3");
        queue.poll();
        queue.destroy();
    }

    @Override
    public void distributedObjectCreated(DistributedObjectEvent event) {
        DistributedObject instance = event.getDistributedObject();
        System.out.println("create " + instance.getName());
    }

    @Override
    public void distributedObjectDestroyed(DistributedObjectEvent event) {

        System.out.println("destory " + event.getServiceName() + "   objectName: " + event.toString());
    }
}
