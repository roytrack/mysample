package com.roytrack.netty.delimiter5_2_1;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by roytrack on 2016/5/24.
 */
public class EchoClientHandler extends ChannelHandlerAdapter {

    private int count;
    static  final String ECHO_REQ="Hi,welcome to Netty.$_";

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i <10 ; i++) {
            String s="";
            if(i%2==0){
                s="12345678901234567890";
            }else{
                s="aaaaaaaaaa";
            }
            ctx.writeAndFlush(Unpooled.copiedBuffer(s.getBytes()));
            System.out.println("client write to server "+i);
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("This is "+ ++count+" times  receive server:["+msg+"]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
