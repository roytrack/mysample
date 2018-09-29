package com.roytrack.dailytest.simplejava;

import org.junit.Test;

/**
 * Created by roytrack on 2015/1/13.
 */
public class IntDivide {
  @Test
  public void divideTest() {
    int a = 10 / 3;
    int b = 11 / 3;
    Integer ten = 10;
    Integer three = 3;
    Integer c = ten / three;
    System.out.println("10/3===" + a + " 11/3===" + b + "ten/three===" + c);
  }

  @Test
  public void yuTest() {
    int a = 10 % 3;
    int b = 11 % 3;
    Integer ten = 10;
    Integer three = 3;
    Integer c = ten % three;
    System.out.println("10%3===" + a + " 11%3===" + b + "ten%three===" + c);
  }
}
