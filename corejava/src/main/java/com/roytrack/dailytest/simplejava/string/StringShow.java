package com.roytrack.dailytest.simplejava.string;

/**
 * Created by roy on 2017/7/11.
 */
public class StringShow {
  public static void main(String[] args) {
    String str = "hello";
    String str1 = str + "";
    String str2 = str1.intern();
    String str3 = str;
    String str4 = str;
    str = null;
    System.out.println(str4);
  }
}
