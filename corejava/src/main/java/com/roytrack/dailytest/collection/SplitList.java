package com.roytrack.dailytest.collection;

import java.util.Arrays;
import java.util.List;

/**
 * Created by roytrack on 2015/8/24.
 */
public class SplitList {

    public static void main(String[] args) {
        List<Integer> integers= Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);
        List<Integer> subList1=integers.subList(1,5);
        StringBuilder sb1=new StringBuilder("");
        for(Integer i:subList1){
            sb1.append(i+",");
        }
        System.out.println(sb1.toString());
        List<Integer> subList2=integers.subList(5,integers.size());
        sb1.delete(0,sb1.toString().length());
        System.out.println(sb1);
        for(Integer i:subList2){
            sb1.append(i+",");
        }
        System.out.println(sb1.toString());
    }
}
