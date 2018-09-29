package com.roytrack.dailytest.simplejava.thread;

/**
 * Created by roytrack on 2015/5/11.
 */
public class FailAndRepeat {
  public static void main(String[] args) {
    new ReDo(10, "ten time");
    new ReDo(11, "eleven time");
  }


}

class ReDo implements Runnable {
  boolean success = false;
  int a;
  String b;

  public ReDo(int a, String b) {
    this.a = a;
    this.b = b;
    new Thread(this, b).start();
  }

  @Override
  public void run() {
    while (!success) {
      try {
        for (int i = 0; i < 11; i++) {
          System.out.println("thread " + b + "  " + (a / (a - i)));
        }
        success = true;
      } catch (Exception e) {
        try {
          Thread.sleep(10000L);
        } catch (InterruptedException e1) {
          e1.printStackTrace();
        }
      }
    }
    System.out.println("=====" + b);

  }
}