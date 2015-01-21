package com.roytrack.dailytest.simplejava;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by roytrack on 2015/1/20.
 */
public class BigDecimalMultiply {

    @Test
    public void multiply(){
        BigDecimal aa=new BigDecimal("55.55");
        BigDecimal bb=new BigDecimal("40.2");
        System.out.println(aa.multiply(bb));
        System.out.println("=================");
        BigDecimal cc=new BigDecimal("-40.33");
//        System.out.println(aa.setScale(0,BigDecimal.ROUND_FLOOR));
//        System.out.println(cc.setScale(0,BigDecimal.ROUND_FLOOR));

        System.out.println(aa.setScale(0,BigDecimal.ROUND_CEILING));
        System.out.println(cc.setScale(0,BigDecimal.ROUND_CEILING));

//        System.out.println(aa.setScale(0,BigDecimal.ROUND_DOWN));
//        System.out.println(cc.setScale(0,BigDecimal.ROUND_DOWN));
    }
}
