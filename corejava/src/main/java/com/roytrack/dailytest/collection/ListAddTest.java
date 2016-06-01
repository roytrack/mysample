package com.roytrack.dailytest.collection;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-05-31.
 */
public class ListAddTest {
    public static void main(String[] args) {
        long start=System.nanoTime();
        System.out.println(start);
        ArrayList<Integer>a=new ArrayList<>(10000);
        for(int i=0;i<10000;i++){
            a.add(i);
        }
        System.out.println(System.nanoTime()-start);
    }
}
