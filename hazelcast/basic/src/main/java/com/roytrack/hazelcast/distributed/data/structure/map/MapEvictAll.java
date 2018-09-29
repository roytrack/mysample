package com.roytrack.hazelcast.distributed.data.structure.map;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class MapEvictAll {

    public static void main(String[] args) {
        final int numberOfKeysToLock = 4;
        final int numberOfEntriesToAdd = 1000;
        HazelcastInstance node1 = Hazelcast.newHazelcastInstance();
        HazelcastInstance node2 = Hazelcast.newHazelcastInstance();

        IMap<Integer,Integer> map = node1.getMap("map");
        for (int i = 0; i < numberOfEntriesToAdd ; i++) {
            map.put(i,i);
        }
        for (int i = 0; i < numberOfKeysToLock; i++) {
            map.lock(i);
        }
        map.evictAll();
        System.out.println("#after evict all...");
        System.out.printf("# Expected map size\t : %d\n",numberOfKeysToLock);
        System.out.printf("#Actual map size \t : %d\n",map.size());

    }
}
