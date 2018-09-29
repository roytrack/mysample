package com.roytrack.dailytest.simplejava;

import org.junit.Test;

/**
 * Created by roytrack on 2015/1/21.
 */
public class StringSplit {

  @Test
  public void splitWithChinese() {
    String ss = "枯藤老树昏鸦，小桥流水人家，古道西风瘦马，夕阳西下，断肠人在天涯";
    String[] sarray = ss.split("，");
    System.out.println(sarray.length);
    for (String s : sarray) {
      System.out.println(s);
    }
    System.out.println(ss.substring(0, ss.length() - 1));

    String aa = "201102";
    System.out.println(aa.substring(0, 4) + "@@" + aa.substring(4));
  }
}
