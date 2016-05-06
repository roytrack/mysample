package com.roytrack.netty.netty4_2_package_error;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.logging.Logger;

/**
 * Created by ruanchangming on 2016-05-04.
 */
public class TimeClientHandler extends ChannelHandlerAdapter{
    private static final Logger logger=Logger.getLogger(TimeClientHandler.class.getName());

    private int counter;



    private byte[] seq;

    public TimeClientHandler() {
        seq=("time"+System.getProperty("line.separator")).getBytes();
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            logger.warning("Unexpected exception  from downstream :"+cause.getMessage());
            ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf message=null;
        for(int i=0;i<100;i++){
            message=Unpooled.buffer(seq.length);
            message.writeBytes(seq);
            ctx.writeAndFlush(message);
        }

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf=(ByteBuf)msg;
        byte[] req=new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body=new String(req,"UTF-8");
        System.out.println("Now is : " + body+" ; the counter is :"+ ++counter);

    }



}
