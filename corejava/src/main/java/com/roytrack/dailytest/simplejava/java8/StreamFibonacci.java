package com.roytrack.dailytest.simplejava.java8;

import org.junit.Test;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by roytrack on 2015/1/14.
 */
public class StreamFibonacci implements Supplier<Long> {
  long a = 0, b = 1;

  @Override
  public Long get() {
    long x = a + b;
    a = b;
    b = x;
    return a;
  }

  @Test
  public void OperateFibonacciTen() {
    Stream<Long> fibonacci = Stream.generate(new StreamFibonacci());
    fibonacci.filter(n -> {
      return n > 3;
    }).limit(10).forEach(System.out::println);
  }
}
