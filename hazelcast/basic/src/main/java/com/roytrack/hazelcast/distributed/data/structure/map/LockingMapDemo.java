package com.roytrack.hazelcast.distributed.data.structure.map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class LockingMapDemo {

  public static void main(String[] args) throws Exception {

    LockingMapDemo demo = new LockingMapDemo();
    demo.pessimisticUpdateMember();
    demo.optimisticMember();

  }

  public void pessimisticUpdateMember() throws Exception {
    HazelcastInstance hz = Hazelcast.newHazelcastInstance();
    IMap<String, Customer> map = hz.getMap("map");
    String key = "1";
    Customer initCustomer = new Customer(key);
    initCustomer.setAge(1);
    initCustomer.setName("roy");
    map.put(key, initCustomer);
    System.out.println("Starting");
    for (int k = 0; k < 1000; k++) {
      map.lock(key);
      try {
        Customer customer = map.get(key);
        Thread.sleep(10);
        customer.setAge(customer.getAge() + 1);
        map.put(key, customer);
      } finally {
        map.unlock(key);
      }
    }
    System.out.println("Finished! Result = " + map.get(key).getAge());
    hz.shutdown();
  }

  public void optimisticMember() throws InterruptedException {
    HazelcastInstance hz = Hazelcast.newHazelcastInstance();
    IMap<String, Customer> map = hz.getMap("map");
    String key = "1";
    Customer initCustomer = new Customer(key);
    initCustomer.setAge(1);
    initCustomer.setName("roy");
    map.put(key, initCustomer);
    System.out.println("Starting");
    for (int k = 0; k < 1000; k++) {
      if (k % 10 == 0) System.out.println("At: " + k);
      for (; ; ) {
        Customer oldValue = map.get(key);
        Customer newValue = Customer.clone(oldValue);
        Thread.sleep(10);
        newValue.setAge(newValue.getAge() + 1);
        if (map.replace(key, oldValue, newValue))
          break;
      }
    }
    System.out.println("Finished! Result = " + map.get(key).getAge());
    hz.shutdown();
  }

}
