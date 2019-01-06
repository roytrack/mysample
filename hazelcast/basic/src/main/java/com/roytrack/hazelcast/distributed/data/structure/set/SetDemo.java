package com.roytrack.hazelcast.distributed.data.structure.set;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ISet;

public class SetDemo {
  public static void main(String[] args) {
    HazelcastInstance hz = Hazelcast.newHazelcastInstance();
    ISet<String> set = hz.getSet("set");
    set.add("Tokyo");
    set.add("Paris");
    set.add("London");
    set.add("New York");
    System.out.println("Putting finished!");
  }
}
