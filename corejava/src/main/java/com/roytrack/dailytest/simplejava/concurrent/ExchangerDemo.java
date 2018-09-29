package com.roytrack.dailytest.simplejava.concurrent;

import java.util.concurrent.Exchanger;

/**
 * Created by roytrack on 2015/4/15.
 */
public class ExchangerDemo {
  public static void main(String[] args) {
    Exchanger<String> ex = new Exchanger<>();
    new MakeRubbish(ex);
    new UseRubbish(ex);
  }

}

class MakeRubbish implements Runnable {
  Exchanger<String> ex;
  String str;

  MakeRubbish(Exchanger<String> exchanger) {
    ex = exchanger;
    str = new String();
    new Thread(this).start();
  }

  @Override
  public void run() {
    char ch = 'a';
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 5; j++) {
        str += ch++;
      }
      System.out.println("put " + str);
      try {
        str = ex.exchange(str);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }
}

class UseRubbish implements Runnable {
  Exchanger<String> ex;
  String str;

  UseRubbish(Exchanger<String> exchanger) {
    ex = exchanger;
    new Thread(this).start();
  }


  @Override
  public void run() {
    for (int i = 0; i < 3; i++) {
      try {
        str = ex.exchange(new String());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("got " + str);
    }
  }
}
