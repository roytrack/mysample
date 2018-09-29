package com.roytrack.dailytest.number;

import java.util.regex.Pattern;

/**
 * Created by roytrack on 2016/3/22.
 */
public class SpecialNumber {
  public static void main(String[] args) {
    System.out.println(0x00004000);
    System.out.println(0x00000010);
    System.out.println(0x00000040);
    int a = 190;
    int b = 100;
    int c = a / b;
    System.out.println(c);
    String aa = "aaa";
    String bb = "2323sd";
    String cc = "5423534 ";
    System.out.println(isNumeric(aa));
    System.out.println(isNumeric(bb));
    System.out.println(isNumeric(cc));
  }

  public static boolean isNumeric(String str) {
    Pattern pattern = Pattern.compile("[0-9]*");
    return pattern.matcher(str).matches();
  }
}
