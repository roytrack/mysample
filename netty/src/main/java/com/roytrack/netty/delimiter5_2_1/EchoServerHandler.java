package com.roytrack.netty.delimiter5_2_1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by roytrack on 2016/5/23.
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

  int count = 0;

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    cause.printStackTrace();
    ctx.close();
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) {
    String body = (String) msg;
    System.out.println("This is" + ++count + " times receive client:[" + body + "]");
    ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
    ctx.writeAndFlush(echo);
  }
}
