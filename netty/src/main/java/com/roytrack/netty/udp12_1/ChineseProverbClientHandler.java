package com.roytrack.netty.udp12_1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

/**
 * Created by roytrack on 2017-04-07.
 */
public class ChineseProverbClientHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        String response=msg.content().toString(CharsetUtil.UTF_8);
        if(response.startsWith("谚语查询结果")){
            System.out.println("收到服务端信息："+response);
            ctx.close();
        }
    }
}
