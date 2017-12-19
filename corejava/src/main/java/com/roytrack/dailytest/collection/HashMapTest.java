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

        HashMap<String,String> b=new HashMap<>();
        b.put("a1","c");
        b.put("a2","c");
        b.put("a3","c");
        b.put("a4","c");
        b.put("a5","c");
        b.put("a6","c");
        b.put("a7","c");
        b.put("a8","c");
        b.put("a9","c");
        b.put("a10","c");
        b.put("a11","c");
        b.put("a12","c");
        b.put("a13","c");
        b.put("a14","c");
        b.put("a15","c");
        b.put("a16","c");
         itr=b.entrySet().iterator();
        i=0;
        while (itr.hasNext()){
            Map.Entry<String,String> entry=itr.next();
            System.out.println("打印第"+i+"ge key $"+entry.getKey()+"$ val $"+entry.getValue()+"$");
            i++;
        }
    }


}
