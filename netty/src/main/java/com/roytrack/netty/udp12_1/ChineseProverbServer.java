package com.roytrack.netty.udp12_1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * Created by roytrack on 2017-03-24.
 */
public class ChineseProverbServer {

  public static void main(String[] args) throws InterruptedException {
    ChineseProverbServer s = new ChineseProverbServer();
    s.run(8080);
  }

  public void run(int port) throws InterruptedException {
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
      Bootstrap b = new Bootstrap();
      b.group(workerGroup)
              .channel(NioDatagramChannel.class)
              .option(ChannelOption.SO_BROADCAST, true)
              .handler(new ChineseProverbServerHandler());
      b.bind(8080).sync()
              .channel().closeFuture().await();
    } finally {
      workerGroup.shutdownGracefully();
    }
  }
}
