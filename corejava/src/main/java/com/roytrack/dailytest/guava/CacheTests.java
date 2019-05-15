package com.roytrack.dailytest.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ConcurrentMap;

/**
 * 14秒放入1kw
 */
public class CacheTests {

  public static void main(String[] args) throws InterruptedException {
    Cache<Long, Long> cache = CacheBuilder.newBuilder().maximumSize(1_0000).build();
    for (int i = 0; i < 2_0000; i++) {
      Long l = Long.valueOf(i);
      if (i % 1_000 == 0) {
        System.out.println(System.currentTimeMillis() + " put " + i);
      }
      cache.put(l, l);
    }
    System.out.println(cache.size());
    ConcurrentMap map = cache.asMap();
    System.out.println(map.keySet());
    Thread.sleep(100000);
  }
}
