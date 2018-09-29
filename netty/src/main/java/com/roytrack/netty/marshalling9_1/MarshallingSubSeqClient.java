package com.roytrack.netty.marshalling9_1;


import com.roytrack.netty.jdkSerial7_1.SubSeqClientHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * Created by roytrack on 2017-03-17.
 */
public class MarshallingSubSeqClient {

  public static void main(String[] args) throws InterruptedException {
    int port = 8080;
    if (args != null && args.length > 0) {
      try {
        port = Integer.valueOf(args[0]);
      } catch (NumberFormatException e) {

      }
    }
    new MarshallingSubSeqClient().connect(port, "127.0.0.1");

  }

  public void connect(int port, String host) throws InterruptedException {
    EventLoopGroup group = new NioEventLoopGroup();
    try {

      Bootstrap b = new Bootstrap();
      b.group(group).channel(NioSocketChannel.class)
              .option(ChannelOption.SO_BACKLOG, 100)
              .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) {
                  ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder())
                          .addLast(MarshallingCodeCFactory.buildMarshallingEncoder())
                          .addLast(new SubSeqClientHandler());
                }
              });
      ChannelFuture f = b.connect(host, port).sync();
      f.channel().closeFuture().sync();
    } finally {
      group.shutdownGracefully();
    }
  }
}
