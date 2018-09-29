package com.roytrack.dailytest.number;

import java.util.Random;

public class LongTest {

  public static void main(String[] args) {
//                longHashTest();
    getBitVal();

  }

  public static void getBitVal() {
    Long ap = new Long(Math.subtractExact(1l << 31, 1));
    System.out.println(Long.toBinaryString(ap));
    System.out.println(Long.toBinaryString(ap ^ (ap >>> 32)));
  }

  public static void longHashTest() {
    System.out.println(1l << 31);
    Long ap = new Long(Math.subtractExact(1l << 31, 1));
    System.out.println("l is " + ap + ", l hashcode is " + ap.hashCode() + " they are equal ?" + ap.equals(new Long(ap.hashCode())));

    Long a1 = 1l;
    Long a2 = 2l;
    Long a3 = 3l;
    Long a4 = 4l;
    Long a5 = 5l;
    Long a6 = 6l;
    Long a7 = 7l;
    Long a8 = 8l;
    System.out.println(a1.hashCode());
    System.out.println(a2.hashCode());
    System.out.println(a3.hashCode());
    System.out.println(a4.hashCode());
    System.out.println(a5.hashCode());
    System.out.println(a6.hashCode());
    System.out.println(a7.hashCode());
    System.out.println(a8.hashCode());


    Random r = new Random();
    for (int j = 0; j++ < 100; ) {
      Long i = r.nextLong();
      Long l = new Long(i);
      System.out.println("l is " + l + ", l hashcode is " + l.hashCode() + " they are equal ?" + l.equals(new Long(l.hashCode())));
    }


  }
}
