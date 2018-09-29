package com.roytrack.netty.aio2_4_1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * Created by roytrack on 2016-3-25.
 */
public class AsyncTimeServerHandler implements Runnable {
  CountDownLatch latch;
  AsynchronousServerSocketChannel asynchronousServerSocketChannel;
  private int port;

  public AsyncTimeServerHandler(int port) {
    this.port = port;
    try {
      asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
      asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
      System.out.println("The time server is start at port :" + port);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    latch = new CountDownLatch(1);
    doAccept();
    try {
      latch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

  private void doAccept() {
    asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());
  }
}
