package com.roytrack.jvm;

/**
 * Created by roytrack on 2015/8/5.
 */
public class ByteClass {

  private int m;

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println(i);
    }
    System.out.println(System.currentTimeMillis());
  }

  public int inc() {
    return m + 1;
  }

}
