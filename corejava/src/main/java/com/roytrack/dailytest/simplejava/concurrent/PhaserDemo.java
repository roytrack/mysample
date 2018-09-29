package com.roytrack.dailytest.simplejava.concurrent;

import java.util.concurrent.Phaser;

/**
 * Created by roytrack on 2015/4/16.
 */
public class PhaserDemo {
  public static void main(String[] args) throws InterruptedException {
    Phaser p = new Phaser(1);
    int curPhase;
    System.out.println("Start....." + p.getRegisteredParties());
    new MyThread3(p, "A");
    Thread.sleep(1000);
    new MyThread3(p, "B");
    Thread.sleep(1000);
    new MyThread3(p, "C");
    curPhase = p.getPhase();
    p.arriveAndAwaitAdvance();
    System.out.println("Phase" + curPhase + " Complete");
    curPhase = p.getPhase();
    p.arriveAndAwaitAdvance();
    System.out.println("Phase" + curPhase + " Complete");
    curPhase = p.getPhase();
    p.arriveAndAwaitAdvance();
    System.out.println("Phase" + curPhase + " Complete");
    p.arriveAndDeregister();
    if (p.isTerminated()) {
      System.out.println("Phaser is terminated");
    }

  }
}

class MyThread3 implements Runnable {
  Phaser p;

  MyThread3(Phaser phaser, String name) {
    p = phaser;
    p.register();
    new Thread(this, name).start();
  }

  public void run() {
    System.out.println(Thread.currentThread().getName() + " Beginning Phase One" + " now arrived party is " + p.getRegisteredParties());
    p.arriveAndAwaitAdvance();
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " Beginning Phase Two" + " now arrived party is " + p.getRegisteredParties());
    p.arriveAndAwaitAdvance();
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " Beginning Phase Three" + " now arrived party is " + p.getRegisteredParties());
    p.arriveAndDeregister();


  }
}