package com.roytrack.dailytest.collection;

import java.util.HashSet;

/**
 * Created by roytrack on 2017/7/4.
 */
public class HashSetToArray {
    public static void main(String[] args) {
        HashSet<String> set=new HashSet<>();
        set.add("abc");
        set.add("bcd");
        String [] a=set.toArray(new String[0]);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
