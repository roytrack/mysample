package com.roytrack.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.config.MemberGroupConfig;
import com.hazelcast.config.PartitionGroupConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class CustomGroup {
    public static void main(String[] args) {
        Config config = new Config();
        config.setProperty("hazelcast.logging.type", "slf4j");
        config.setInstanceName("roy");
        PartitionGroupConfig partitionGroupConfig = config.getPartitionGroupConfig();
        partitionGroupConfig.setEnabled(true)
                .setGroupType(PartitionGroupConfig.MemberGroupType.HOST_AWARE);
        MemberGroupConfig memberGroupConfig = new MemberGroupConfig();
        memberGroupConfig.addInterface("127.0.0.*");

        MemberGroupConfig memberGroupConfig2 = new MemberGroupConfig();
        memberGroupConfig2.addInterface("10.10.10.*");
        partitionGroupConfig.addMemberGroupConfig(memberGroupConfig)
                .addMemberGroupConfig(memberGroupConfig2);
        HazelcastInstance hazelcast = Hazelcast.newHazelcastInstance(config);
        config.setInstanceName("roy2");
        HazelcastInstance hazelcast2 = Hazelcast.newHazelcastInstance(config);
        config.setInstanceName("roy3");
        HazelcastInstance hazelcast3 = Hazelcast.newHazelcastInstance(config);


        config = new Config("track");
        config.setProperty("hazelcast.logging.type", "slf4j");
        config.setProperty("hazelcast.heartbeat.failuredetector.type", "deadline");
        config.setProperty("hazelcast.heartbeat.interval.seconds", "5");
        config.setProperty("hazelcast.max.no.heartbeat.seconds", "120");
        config.getPartitionGroupConfig().setEnabled(true)
                .setGroupType(PartitionGroupConfig.MemberGroupType.PER_MEMBER);

        HazelcastInstance hazelcast4 = Hazelcast.newHazelcastInstance(config);
        config.setInstanceName("track2");
        HazelcastInstance hazelcast5 = Hazelcast.newHazelcastInstance(config);
        config.setInstanceName("track3");
        HazelcastInstance hazelcast6 = Hazelcast.newHazelcastInstance(config);

    }
}
