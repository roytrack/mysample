package com.roytrack.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.map.listener.EntryExpiredListener;

public class ProgrammaticallyConfig {
  public static void main(String[] args) {
    Config config = new Config();
    config.getNetworkConfig().setPort(8686)
            .setPortAutoIncrement(false);
    MapConfig mapConfig = new MapConfig();
    mapConfig.setName("roytrack")
            .setBackupCount(3)
            .setTimeToLiveSeconds(10);
    config.addMapConfig(mapConfig);
    HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
    config = new Config();
    config.setInstanceName("roy");
    instance = Hazelcast.newHazelcastInstance(config);
    System.out.println("hazelcast instance is :");
    Hazelcast.getAllHazelcastInstances().stream().forEach(v -> {
      System.out.print(v.getName() + "\t");
    });

    ClientConfig clientConfig = new ClientConfig();
    clientConfig.getNetworkConfig().addAddress("127.0.0.1:8686");
    HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
    IMap map = client.getMap("roytrack");

    EntryExpiredListener expiredListener = new EntryExpiredListener() {
      @Override
      public void entryExpired(EntryEvent event) {
        System.out.println("one key is expired : " + event.getKey() + " ,value : " + event.getValue() + "  , source is " + event.getSource() + " , member is : " + event.getMember());
        System.out.println("event is " + event);
      }
    };
    map.addEntryListener(expiredListener, true);


    map.put("a", "ss");


  }
}
