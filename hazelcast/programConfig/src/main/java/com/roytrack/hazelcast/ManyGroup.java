package com.roytrack.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class ManyGroup {
  public static void main(String[] args) {
    Config configPrd = new Config();
    configPrd.getGroupConfig().setName("prd");
    Config configDev = new Config();
    configDev.getGroupConfig().setName("dev");
    HazelcastInstance h1 = Hazelcast.newHazelcastInstance(configPrd);
    HazelcastInstance h2 = Hazelcast.newHazelcastInstance(configDev);
    HazelcastInstance h3 = Hazelcast.newHazelcastInstance(configDev);

  }
}
