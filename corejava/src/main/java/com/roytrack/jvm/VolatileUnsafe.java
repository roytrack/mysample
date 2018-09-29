package com.roytrack.jvm;

/**
 * Created by roytrack on 2015/8/17.
 */
public class VolatileUnsafe {

  private static final int THREADS_COUNT = 20;
  public static volatile int race = 0;

  public static void increase() {
    race++;
  }

  public static void main(String[] args) {
    Thread[] threads = new Thread[THREADS_COUNT];
    for (int i = 0; i < THREADS_COUNT; i++) {
      threads[i] = new Thread(new Runnable() {
        @Override
        public void run() {
          for (int i = 0; i < 10000; i++) {
            increase();
          }
        }
      });
      threads[i].start();
    }
    while (Thread.activeCount() > 1) {
      Thread.yield();
    }

    System.out.println(race);
  }
}
