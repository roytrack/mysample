package com.roytrack.netty.marshalling9_1;

import com.roytrack.netty.jdkSerial7_1.SubReqServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * Created by roytrack on 2017-03-17.
 */
public class MarshallingSubSeqServer {
  public static void main(String[] args) throws InterruptedException {
    int port = 8080;
    if (args != null && args.length > 0) {
      try {
        port = Integer.valueOf(args[0]);
      } catch (NumberFormatException e) {

      }
    }
    new MarshallingSubSeqServer().bind(port);

  }

  public void bind(int port) throws InterruptedException {
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    try {
      ServerBootstrap b = new ServerBootstrap();
      b.group(bossGroup, workerGroup)
              .channel(NioServerSocketChannel.class)
              .option(ChannelOption.SO_BACKLOG, 100)
              .handler(new LoggingHandler(LogLevel.INFO))
              .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) {
                  ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder())
                          .addLast(MarshallingCodeCFactory.buildMarshallingEncoder())
                          .addLast(new SubReqServerHandler());
                }
              });
      ChannelFuture f = b.bind(port).sync();
      f.channel().closeFuture().sync();

    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }
}
