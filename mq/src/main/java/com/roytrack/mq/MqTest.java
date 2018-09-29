package com.roytrack.mq;

/**
 * Created by roytrack on 2017-03-29.
 */
public class MqTest {

  ThreadPoolManager tpm = ThreadPoolManager.newInstance();

  public static void main(String[] args) {
    for (int i = 0; i < 1000; i++) {
      new MqTest().sendMsg("第" + i + "条信息");
    }
  }

  public void sendMsg(String msg) {
    tpm.addLogMsg(msg);
  }
}
