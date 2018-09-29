package com.roytrack.jvm;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * Created by roytrack on 2015/8/13.
 */
public class MethodHandleDemo {
  public static void main(String[] args) throws Throwable {
    Object o = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
    System.out.println(o);
    getPrintMH(o).invokeExact("roytrack");
    ClassA a = new ClassA();
    a.println("sdsds");

  }

  private static MethodHandle getPrintMH(Object receiver) throws NoSuchMethodException, IllegalAccessException {
    MethodType mt = MethodType.methodType(void.class, String.class);

    return lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
  }

  static class ClassA {
    public void println(String s) {
      System.out.println(s);
    }
  }


}
