package com.roytrack.hazelcast.distributed.data.structure.map.listener;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.query.SqlPredicate;

public class Modify {
  public static void main(String[] args) {
    Config config = new Config();
    config.setProperty("hazelcast.map.entry.filtering.natural.event.types","true");
    HazelcastInstance hz = Hazelcast.newHazelcastInstance(config);
    IMap<String,Employee> map = hz.getMap("map");
    Employee smith =new Employee("smith");
    map.put("1",smith);
    map.put("2",new Employee("jordan"));
    System.out.println("origin map size is "+map.size());
    map.remove("1",new Employee("smith"));
    System.out.println("1 remove with new ,map size is "+map.size());
    map.remove("1",smith);
    System.out.println("1 remove with old ,map size is "+map.size());
    System.out.println("done");
    System.exit(0);

  }
}
