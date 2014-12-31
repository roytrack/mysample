package com.roytrack.dailytest;

import java.math.BigDecimal;

/**
 * Created by ruanchangming on 2014/12/30.
 */
public class BigDecimalToStringNoE {
    public static void main(String[] args) {
        System.out.println(String_String_Enum.getEnum("2000").getDesc());
        System.out.println((new BigDecimal("100000000000000000").stripTrailingZeros().toPlainString()));
        System.out.println((new BigDecimal("100000000000000000").stripTrailingZeros().toString()));
        System.out.println((new BigDecimal("100000000000000000").stripTrailingZeros().toEngineeringString()));
    }
}
