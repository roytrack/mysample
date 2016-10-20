package com.roytrack.netty.jdkSerial7_1;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by roytrack on 2016-10-20.
 */
public class SubSeqClientHandler extends ChannelHandlerAdapter{

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        for(int i=0;i<10;i++){
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private SubscribeReq subReq(int i) {
        SubscribeReq req=new SubscribeReq();
        req.setAddress("中国北京");
        req.setPhoneNumber("18888*****");
        req.setProductName("Netty 权威指南");
        req.setSubSeqID(i);
        req.setUserName("roytrack");
        return req;
    }

    @Override
    public  void channelRead(ChannelHandlerContext ctx,Object msg){
        System.out.println("Receive server response : [" + msg + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx){
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }

}
