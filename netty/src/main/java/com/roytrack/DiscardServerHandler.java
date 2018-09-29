package com.roytrack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by roytrack on 2015/9/24.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object arg) {

    System.out.println(((ByteBuf) arg).toString(io.netty.util.CharsetUtil.US_ASCII));
//        ByteBuf in=(ByteBuf)arg;
//        try{

//            while (in.isReadable()){
//                System.out.print((char)in.readByte());
//                System.out.flush();
//            }

//        }finally {
//            ReferenceCountUtil.release(arg);
//        }
//        ctx.writeAndFlush(arg);
    ctx.write(arg);
    ctx.flush();
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    cause.printStackTrace();
    ctx.close();
  }


}
