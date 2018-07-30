package com.roytrack.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.core.*;
import com.hazelcast.map.eviction.MapEvictionPolicy;
import com.hazelcast.map.listener.EntryEvictedListener;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class MapCustomEvictionPolicy {
    public static void main(String[] args) {
        Config config = new Config();
        config.getMapConfig("test")
                .setMapEvictionPolicy(new OddEvictor())
                .getMaxSizeConfig()
                .setMaxSizePolicy(MaxSizeConfig.MaxSizePolicy.PER_NODE)
                .setSize(10000);
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
        IMap<Integer,Integer> map = instance.getMap("test");

        final Queue<Integer> oddKeys = new ConcurrentLinkedDeque<>();
        final Queue<Integer> evenKeys = new ConcurrentLinkedDeque<>();

        map.addEntryListener((EntryEvictedListener<Integer, Integer>) event -> {
            Integer key = event.getKey();
            if ( key % 2 == 0){
                evenKeys.add(key);
            }else {
                oddKeys.add(key);
            }

        },false);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 15000; i++) {
            map.put(i,i);
        }
        String msg = "IMap uses sampling based eviction.After eviction is completed,"
                +"we are expecting number of evicted-odd-keys should be greater than"
                +" number of evicted-even-keys \nNumber of evicted-odd-keys = %d,number"
                +" of evicted-even-keys = %d";
        System.out.printf(msg,oddKeys.size(),evenKeys.size());
        

    }

    private static class OddEvictor extends MapEvictionPolicy {
        @Override
        public int compare(EntryView entryView1, EntryView entryView2) {
            Integer key = (Integer)entryView1.getKey();
            if(key % 2 != 0){
                return -1;
            }
            return 1;
        }


    }
}
