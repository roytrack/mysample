package com.roytrack.netty.aio2_4_1;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

/**
 * Created by roytrack on 2016-3-25.
 */
public class AcceptCompletionHandler implements java.nio.channels.CompletionHandler<java.nio.channels.AsynchronousSocketChannel, AsyncTimeServerHandler> {

  @Override
  public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {
    attachment.asynchronousServerSocketChannel.accept(attachment, this);
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    result.read(buffer, buffer, new ReadCompletionHandler(result));
  }

  @Override
  public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
    exc.printStackTrace();
    attachment.latch.countDown();
  }
}
