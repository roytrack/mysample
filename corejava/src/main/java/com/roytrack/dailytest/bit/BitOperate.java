package com.roytrack.dailytest.bit;

/**
 * Created by roy on 2017/6/19.
 */
public class BitOperate {

    public static void main(String[] args) {
        int a=128;
        System.out.println(Integer.toBinaryString(a));
        a=a-1;
        System.out.println(Integer.toBinaryString(a));
        a=a&128;
        System.out.println(Integer.toBinaryString(a));
        a=129;
        a=a>>1;
        System.out.println(Integer.toBinaryString(a));
        a=a<<1;
        System.out.println(Integer.toBinaryString(a));

    }
}
