package com.roytrack.dailytest.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roytrack on 2015/8/24.
 */
public class NullCollection {

  public static void main(String[] args) {
    List<String> aa = new ArrayList<String>();
    aa.add(null);
    System.out.println(aa.size());
    List<Integer> list = null;
    list = new ArrayList<>();
    for (Integer i : list) {
      System.out.println(i + "   s");
    }
    list = null;
    for (Integer i : list) {
      System.out.println(i);
    }
  }
}
