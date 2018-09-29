package com.roytrack.netty.jdkSerial7_1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by roytrack on 2016-10-19.
 */
public class SubReqServerHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) {
    SubscribeReq req = (SubscribeReq) msg;
    if ("roytrack".equalsIgnoreCase(req.getUserName())) {
      System.out.println("Service accept client subscribe req : [" + req.toString() + "]");
      ctx.writeAndFlush(resp(req.getSubSeqID()));
    }
  }

  private Object resp(int subReqID) {
    SubscribeResp resp = new SubscribeResp();
    resp.setSubReqID(subReqID);
    resp.setRespCode(0);
    resp.setDesc("netty book order succeed, 3 days later, sent to the designated address");
    return resp;
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    cause.printStackTrace();
    ctx.close();
  }


}
