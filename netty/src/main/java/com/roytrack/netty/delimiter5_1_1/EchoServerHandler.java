package com.roytrack.netty.delimiter5_1_1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by roytrack on 2016/5/23.
 */
public class EchoServerHandler extends ChannelHandlerAdapter {

    int count=0;
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body=(String)msg;
        System.out.println("This is"+ ++count+" times receive client:["+body+"]");
        body+="$_";
        ByteBuf echo= Unpooled.copiedBuffer(body.getBytes());
        ctx.writeAndFlush(echo);
    }
}
