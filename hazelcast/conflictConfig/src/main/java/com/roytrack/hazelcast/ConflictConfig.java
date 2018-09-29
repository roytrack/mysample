package com.roytrack.hazelcast;

import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * @author roytrack
 * @time 2018/7/23 上午11:27
 */
public class ConflictConfig {
  public static void main(String[] args) {
    HazelcastInstance instance = Hazelcast.newHazelcastInstance();
    MapConfig sessionMapConfig = new MapConfig("sessions").setBackupCount(0);
    instance.getConfig().addMapConfig(sessionMapConfig);
    MapConfig sessionMapConfigWithBackup = new MapConfig("sessions").setBackupCount(1);
    instance.getConfig().addMapConfig(sessionMapConfigWithBackup);
    MapConfig sessionMapConfigWithoutBackup = new MapConfig("sessions").setBackupCount(0);
    instance.getConfig().addMapConfig(sessionMapConfigWithoutBackup);
  }
}
