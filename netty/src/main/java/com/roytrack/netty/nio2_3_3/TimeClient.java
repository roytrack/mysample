package com.roytrack.netty.nio2_3_3;

/**
 * Created by roytrack on 2016-3-24.
 */
public class TimeClient {

  public static void main(String[] args) {
    int port = 9009;
    if (null != args && args.length > 0) {
      port = Integer.valueOf(args[0]);
    }
    new Thread(new TimeClienthandler("127.0.0.1", port), "TimeClient-001").start();


  }
}
