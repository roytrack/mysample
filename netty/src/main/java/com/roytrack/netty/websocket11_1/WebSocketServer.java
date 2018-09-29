package com.roytrack.netty.websocket11_1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * Created by roytrack on 2017-03-24.
 */
public class WebSocketServer {
  private static final String url = "10.87.156.46";

  public static void main(String[] args) throws InterruptedException {
    int port = 8080;
    new WebSocketServer().run(port);
  }

  public void run(int port) throws InterruptedException {
    EventLoopGroup bossGroup = new NioEventLoopGroup(1);
    EventLoopGroup workerGroup = new NioEventLoopGroup();
    ServerBootstrap b = new ServerBootstrap();
    try {
      b.group(bossGroup, workerGroup)
              .channel(NioServerSocketChannel.class)
              .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) {
                  ch.pipeline().addLast("http-codec", new HttpServerCodec())
                          .addLast("aggregator", new HttpObjectAggregator(65536))
                          .addLast("http-chunked", new ChunkedWriteHandler())
                          .addLast("handler", new WebSocketServerHandler());
                }
              });
      Channel ch = b.bind(url, port).sync().channel();
      System.out.println("Web socket server started at " + url + ":" + port + ".");
      ch.closeFuture().sync();
    } finally {
      bossGroup.shutdownGracefully();
      workerGroup.shutdownGracefully();
    }
  }
}
