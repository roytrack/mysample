package com.roytrack.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;


public class GetStartedClient {
  public static void main(String[] args) {
    ClientConfig clientConfig = new ClientConfig();
    HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
    IMap map = client.getMap("customers");
    System.out.println("Map Size:" + map.size());
    map.remove(2);
    System.out.println("Map Size:" + map.size());
  }
}
