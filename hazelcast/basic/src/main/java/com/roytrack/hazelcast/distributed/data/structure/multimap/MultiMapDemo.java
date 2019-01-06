package com.roytrack.hazelcast.distributed.data.structure.multimap;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MultiMap;

import java.util.Collection;

public class MultiMapDemo {
  public static void main(String[] args) {
    HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
    MultiMap<String, String> map = hazelcastInstance.getMultiMap("map");
    map.put("a", "0");
    map.put("a", "1");
    map.put("a", "2");
    map.put("b", "3");
    System.out.println("PutMember:Done");

    for (String key : map.keySet()) {
      Collection<String> values = map.get(key);
      System.out.printf("%s -> %s\n", key, values);
    }
    //移除一个
    map.remove("a", "0");
    System.out.println("------------------------------");
    for (String key : map.keySet()) {
      Collection<String> values = map.get(key);
      System.out.printf("%s -> %s\n", key, values);
    }

    //移除所有
    map.remove("a");
    System.out.println("------------------------------");
    for (String key : map.keySet()) {
      Collection<String> values = map.get(key);
      System.out.printf("%s -> %s\n", key, values);
    }

  }
}
