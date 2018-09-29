package com.roytrack.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roytrack on 2015/8/4.
 */
public class OutOfMemoryDemo {

  public static void main(String[] args) {
    OutOfMemoryDemo demo = new OutOfMemoryDemo();
    demo.RuntimeConstantPoolOOM();
  }

  /**
   * vm args
   * -Xms:20M -xmx:20M -XX:+HeapDumpOnOutOfMemoryError
   */

  public void HeapOOM() {
    List<OOMObject> list = new ArrayList<>();
    while (true)
      list.add(new OOMObject());

  }

  /**
   * -XX:PermSize=10M -XX:MaxPermSize=10M
   */
  public void RuntimeConstantPoolOOM() {
    List<String> list = new ArrayList<>();
    int i = 0;
    while (true) {
      list.add(String.valueOf(i++).intern());
      System.out.println(list.size());
    }
  }

  static class OOMObject {

  }

}
