package com.roytrack.dailytest.collection;

import java.util.List;

/**
 * Created by ruanchangming on 2015/8/24.
 */
public class NullCollection {

    public static void main(String[] args) {
        List<Integer> list=null;
        for(Integer i:list){
            System.out.println(i);
        }
    }
}
