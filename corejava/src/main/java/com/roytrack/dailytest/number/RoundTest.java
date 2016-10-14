package com.roytrack.dailytest.number;

import java.math.BigDecimal;

/**
 * 直接将double转成bigdecimal也会造成意义的不准确 但是转成string再转bigdecimal就可以规避
 * Created by roytrack on 2015/11/14.
 */
public class RoundTest {
    public static void main(String[] args) {
        String s=String.valueOf(45.275);
        BigDecimal b=new BigDecimal(s);
        System.out.println(b);
        System.out.println(b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        System.out.println(b.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue());

        BigDecimal a=new BigDecimal(45.275);
        System.out.println(a);
        System.out.println(a.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
        System.out.println(a.setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue());

        BigDecimal c=new BigDecimal("24.5");
        BigDecimal d=new BigDecimal("67.475");
        System.out.println(c.add(d).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());

        int intA=5;
        int intB=4;
        int intC=3;
        int intD=2;
        System.out.println((intA/intB)+"  "+(intA/intC)+"  "+(intA/intD)+"");



        double doublea =1.51;
        BigDecimal e=new BigDecimal(doublea);
        System.out.println(e.setScale(0,BigDecimal.ROUND_CEILING));
        System.out.println(e.setScale(0,BigDecimal.ROUND_HALF_UP));

    }
}
