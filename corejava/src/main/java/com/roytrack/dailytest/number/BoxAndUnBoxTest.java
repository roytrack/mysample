package com.roytrack.dailytest.number;

public class BoxAndUnBoxTest {
  public static void main(String[] args) {
    integerBox();
  }

  public static void integerBox() {
    Integer boxVal = 3;
    int unboxVal = 3;
    boolean result = boxVal == unboxVal;
    System.out.println(result);

    boxVal = 266;
    unboxVal = 266;
    result = boxVal != unboxVal;
    System.out.println(result);
  }
}
