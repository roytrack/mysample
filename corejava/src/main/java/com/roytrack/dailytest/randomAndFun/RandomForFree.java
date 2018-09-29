package com.roytrack.dailytest.randomAndFun;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Administrator on 2017/10/29.
 */
public class RandomForFree {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("夫斯基");
    list.add("格子");
    list.add("胖欢");
    list.add("叉弟");
    list.add("sunshine");
    list.add("亚丽");
    list.add("白晓建");
    list.add("崔疼");


    Random r = new Random();
    System.out.println(list.get(r.nextInt(list.size())));
  }
}
