package com.roytrack.netty.protobuf8_1;

import com.roytrack.netty.protobuf.SubscribeReqC;
import com.roytrack.netty.protobuf.SubscribeRespC;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by roytrack on 2016-10-24.
 */
public class SubReqServerHandler2 extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx,Object msg){
        SubscribeReqC.SubscribeReq req=(SubscribeReqC.SubscribeReq)msg;
        if("roytrack".equalsIgnoreCase(req.getUserName())){
            System.out.println("Service accept client subscribe req : ["+req.toString()+"]");
            ctx.writeAndFlush(resp(req.getSubReqid()));
        }
    }
    private Object resp(int subReqID) {
        SubscribeRespC.SubscribeResp resp=SubscribeRespC.SubscribeResp.getDefaultInstance().toBuilder()
                .setSubReqid(subReqID)
                .setRespCode(0)
                .setDesc("netty book order succeed, 3 days later, sent to the designated address").build();
        return resp;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}
