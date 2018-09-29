package com.roytrack.netty.protobuf8_1;

import com.roytrack.netty.protobuf.SubscribeRespC;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

/**
 * Created by roytrack on 2016-10-24.
 */
public class SubSeqClient {

  public static void main(String[] args) throws InterruptedException {
    int port = 9009;
    if (args != null && args.length > 0) {
      port = Integer.valueOf(args[0]);
    }
    new SubSeqClient().connect(port, "127.0.0.1");
  }

  public void connect(int port, String host) throws InterruptedException {
    EventLoopGroup group = new NioEventLoopGroup();
    try {
      Bootstrap b = new Bootstrap();
      b.group(group)
              .channel(NioSocketChannel.class)
              .option(ChannelOption.TCP_NODELAY, true)
              .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) {
                  ch.pipeline().addLast(new ProtobufVarint32FrameDecoder());
                  ch.pipeline().addLast(new ProtobufDecoder(SubscribeRespC.SubscribeResp.getDefaultInstance()));
                  ch.pipeline().addLast(new ProtobufVarint32LengthFieldPrepender());
                  ch.pipeline().addLast(new ProtobufEncoder());
                  ch.pipeline().addLast(new SubReqClientHandler2());
                }
              });
      ChannelFuture f = b.connect(host, port).sync();
      f.channel().closeFuture().sync();
    } finally {
      group.shutdownGracefully();
    }
  }
}

