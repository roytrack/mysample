package com.roytrack.dailytest.simplejava.exception;

/**
 * Created by roytrack on 2015/2/19.
 */
public class MultipleCatch {
  public static void main(String[] args) {
    try {
//            int a=1,b=0;
//            a=a/b;
      Integer c = null;
      c.byteValue();
    } catch (ArithmeticException | NullPointerException e) {
      System.out.println(e);
    }
  }
}