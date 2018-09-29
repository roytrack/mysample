package com.roytrack.dailytest.override.attribute;

import lombok.Data;

/***
 *
 *   Created by roytrack on 2018-02-28  16:27
 */
@Data
public class SonVO extends FatherVO {
  private String abc;
  private String a12;
  private String a14;

  public static void main(String[] args) {
    SonVO s = new SonVO();
    s.print();
  }

  public void print() {
    SonVO s = new SonVO();
    s.setAbc("1");
    s.setA12("2");
    s.setA14("3");
    System.out.println(s);
    FatherVO v = s;
    System.out.println(v.getAbc() + "   " + v.getA12());
    System.out.println(super.getAbc() + "   " + super.getA12());
  }
}


