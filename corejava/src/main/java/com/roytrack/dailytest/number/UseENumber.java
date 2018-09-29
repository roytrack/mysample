package com.roytrack.dailytest.number;

import org.junit.Test;

import java.text.DecimalFormat;

/**
 * Created by roytrack on 2015/3/31.
 */
public class UseENumber {

  public static String padDoubleLeft(Double d, int totalDigit, int fractionalDigit) {
    String str = "";
    DecimalFormat decimalFormat = new DecimalFormat();
    decimalFormat.setMinimumFractionDigits(fractionalDigit);
    decimalFormat.setMaximumFractionDigits(fractionalDigit);
    decimalFormat.setGroupingUsed(false);
    decimalFormat.setMaximumIntegerDigits(totalDigit - fractionalDigit - 1);
    decimalFormat.setMinimumIntegerDigits(totalDigit - fractionalDigit - 1);
    str = decimalFormat.format(d);
/**
 * 去掉前面的0（比如000123213，最后输出123213）
 */
    while (str.startsWith("0")) {
      str = str.substring(1);
    }
    return str;
  }

  @Test
  public void useE() {
    int a = (int) 1E5;
    System.out.println(a);
    double b = 33 / 1.33e3;
    double c = 1e10;
    System.out.println(b + "  " + c);
  }

  @Test
  public void testNoE() {
    double d = 1.234566e10;
    String str = padDoubleLeft(d, 50, 2);
    System.out.println(str);
  }


  @Test
  public void testStringToDouble() {
    String strWithE = "1.23456e10";
    Double d = Double.parseDouble(strWithE);
    System.out.println(d);
    Double dd = Double.valueOf(strWithE);
    System.out.println(dd);
  }

}
