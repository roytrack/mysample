package com.roytrack.dailytest.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by roytrack on 2016-07-27.
 */
public class ForEachAndIterator {

  @Test
  public void WhichIteratorByList() {
    ArrayList<Integer> a = new ArrayList<>();
    a.add(null);
    a.add(null);
    a.add(5);
    HashMap<String, String> b = new HashMap<>();
    b.put(null, "ss");
    b.put("ss", "ddd");
    System.out.println(a.size() + "   " + a.get(0) + "   " + a.get(1) + "   " + a.get(2));
    System.out.println(b.size() + "   " + b.get(null) + "   " + b.get(b.get(null)));
  }
}
