package com.roytrack.netty.netty3_2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;


/**
 * Created by roytrack on 2016-4-21.
 */
public class TimeClient {

  public static void main(String[] args) throws InterruptedException {
    int port = 9009;
    if (args != null && args.length > 0) {
      try {
        port = Integer.parseInt(args[0]);
      } catch (NumberFormatException e) {

      }
    }
    new TimeClient().connect(port, "127.0.0.1");
  }

  public void connect(int port, String host) throws InterruptedException {
    EventLoopGroup group = new NioEventLoopGroup();
    try {
      Bootstrap b = new Bootstrap();
      b.group(group).channel(NioSocketChannel.class)
              .option(ChannelOption.TCP_NODELAY, true)
              .handler(new ChannelInitializer<io.netty.channel.socket.SocketChannel>() {
                @Override
                protected void initChannel(io.netty.channel.socket.SocketChannel ch) {
                  ch.pipeline().addLast(new TimeClientHandler());
                }
              });
      ChannelFuture f = b.connect(host, port).sync();
      f.channel().closeFuture().sync();
    } finally {
      group.shutdownGracefully();
    }

  }

}
