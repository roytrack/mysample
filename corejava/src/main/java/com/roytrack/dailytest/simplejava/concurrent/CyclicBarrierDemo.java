package com.roytrack.dailytest.simplejava.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by roytrack on 2015/4/15.
 */
public class CyclicBarrierDemo {
  public static void main(String[] args) {
    CyclicBarrier c = new CyclicBarrier(3, new TriggerAction());
    new MyThread2(c, "A");
    new MyThread2(c, "B");
    new MyThread2(c, "C");
    new MyThread2(c, "D");
    new MyThread2(c, "E");
    new MyThread2(c, "F");
  }
}

class MyThread2 implements Runnable {
  CyclicBarrier c;

  MyThread2(CyclicBarrier cyc, String name) {
    c = cyc;
    new Thread(this, name).start();
  }


  public void run() {
    System.out.println(Thread.currentThread().getName() + " run");
    try {
      c.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (BrokenBarrierException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " time is " + System.currentTimeMillis());

  }

}

class TriggerAction implements Runnable {
  public void run() {
    System.out.println(" triggerAction execute");
  }
}
