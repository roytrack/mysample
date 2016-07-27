package com.roytrack.dailytest.collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by roytrack on 2016-07-26.
 */
public class ConcurrentHashMapUse {

    public static void main(String[] args) {
        String sku="600400003099";
        String sku2="600400003099";
        ConcurrentHashMap<String,String> map=new ConcurrentHashMap<>();
        map.put(sku2,"600400003099");
        System.out.println(map.get(sku));
    }
}
