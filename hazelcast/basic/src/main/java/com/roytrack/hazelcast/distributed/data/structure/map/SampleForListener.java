package com.roytrack.hazelcast.distributed.data.structure.map;

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
    IMap<Integer, Integer> map = instance.getMap("map");
    map.put(1, 1);
    map.put(2, 2);
    IQueue queue = instance.getQueue("q1");
    queue.add("sd");
    queue.add("sd3");
    queue.poll();
    queue.destroy();
    instance.shutdown();
  }

  @Override
  public void distributedObjectCreated(DistributedObjectEvent event) {
    System.out.println("create " + event.toString());
  }

  @Override
  public void distributedObjectDestroyed(DistributedObjectEvent event) {

    System.out.println("destory " + event.getServiceName() + "   objectName: " + event.toString());
  }
}
