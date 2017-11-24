package com.roytrack.dailytest.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String,String> a=new LinkedHashMap();
        a.put("a1","c");
        a.put("a2","c");
        a.put("a3","c");
        a.put("a4","c");
        a.put("a5","c");
        a.put("a6","c");
        a.put("a7","c");
        a.put("a8","c");
        a.put("a9","c");
        a.put("a10","c");
        a.put("a11","c");
        a.put("a12","c");
        a.put("a13","c");
        a.put("a14","c");
        Iterator<Map.Entry<String,String>> itr=a.entrySet().iterator();
        int i=0;
        while (itr.hasNext()){
            Map.Entry<String,String> b=itr.next();
            System.out.println("打印第"+i+"ge key $"+b.getKey()+"$ val $"+b.getValue()+"$");
            i++;
        }
    }
}
