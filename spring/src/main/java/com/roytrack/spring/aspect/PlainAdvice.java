package com.roytrack.spring.aspect;

/**
 * Created by roytrack on 2016-09-09.
 */
public class PlainAdvice {
  public void beforeAdvice() {
    System.out.println("this is before");
  }

  public void afterAdvice() {
    System.out.println("this is after");
  }
}
