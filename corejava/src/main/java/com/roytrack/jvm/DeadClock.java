package com.roytrack.jvm;

/**
 * Created by roytrack on 2015/8/5.
 */
public class DeadClock {

  public static void main(String[] args) {

    for (int i = 0; i < 100; i++) {
      new Thread(new AddThread(1, 2)).start();
      new Thread(new AddThread(2, 1)).start();
    }
  }

  static class AddThread implements Runnable {
    int a, b;

    public AddThread(int a, int b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public void run() {
      synchronized (Integer.valueOf(a)) {
        synchronized (Integer.valueOf(b)) {

          System.out.println(Thread.currentThread().getName() + "      " + (a + b));
        }
      }
    }
  }
}
