package com.roytrack.dailytest.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by roytrack on 2016-05-19.
 */
public class IntersectionOfTwoArrays349 {

    public static void main(String[] args) {
        int [] a={1,2,3,4,3,4,3,2};
        int [] b={1,4,2,2,2,5};
        int [] r=intersection(a,b);
        for(int i=0;i<r.length;i++){
            System.out.println(r[i]);
        }
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            Integer result=map.get(nums1[i]);
            if(null==result){
                map.put(nums1[i], 1);
            }
        }
        for(int i=0;i<nums2.length;i++){
            Integer result=map.get(nums2[i]);
             if(null!=result&&1==result){
                map.put(nums2[i],3);
            }
        }
        List<Integer> list=new ArrayList<>();
        Iterator itr=map.keySet().iterator();
        while (itr.hasNext()){
            int b=(int)itr.next();
            int a=map.get(b);
            if(a==3){
                list.add(b);
            }
        }
        int [] result= new int [list.size()];
        for(int j=0;j<result.length;j++){
            result[j]=list.get(j);
        }

        return result;
    }
}
