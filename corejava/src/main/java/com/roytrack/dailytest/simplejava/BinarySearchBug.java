package com.roytrack.dailytest.simplejava;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by ruanchangming on 2015/7/28.
 * 发现实际二分算法是从0开始的，所以后面结尾进行了长度-1
 */
public class BinarySearchBug {

    public static void main(String[] args) {
        int[] intarrys={1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.binarySearch(intarrys, 10));
        ConcurrentHashMap map=new ConcurrentHashMap();

    }
}
