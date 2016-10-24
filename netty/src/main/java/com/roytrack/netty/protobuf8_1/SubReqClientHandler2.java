package com.roytrack.netty.protobuf8_1;

import com.roytrack.netty.protobuf.SubscribeReqC;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by roytrack on 2016-10-24.
 */
public class SubReqClientHandler2 extends ChannelHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx){
        for(int i=0;i<10;i++){
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private SubscribeReqC.SubscribeReq subReq(int i) {
        SubscribeReqC.SubscribeReq req= SubscribeReqC.SubscribeReq.getDefaultInstance();
        req= req.toBuilder().setAddress("中国北京")
                .setUserName("roytrack")
                .setProductName("netty 权威指南")
                .setSubReqid(i).build();
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
