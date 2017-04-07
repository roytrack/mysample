package com.roytrack.netty.udp12_1;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by roytrack on 2017-03-24.
 */
public class ChineseProverbServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

    private static final String[] DICTIONARY = {"床前明月光，疑是地上霜", "曾经沧海难为水，除却巫山不是云",
            "旧时王谢堂前燕，飞入寻常百姓家", "洛阳亲友如相问，一片冰心在玉壶", "一寸光阴一寸金，寸金难买寸光阴", "老骥伏枥，志在千里。烈士暮年，壮心不已。"};


    private String nextQuote() {
        int quoteId = ThreadLocalRandom.current().nextInt(DICTIONARY.length);
        return DICTIONARY[quoteId];
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
        String req = msg.content().toString(CharsetUtil.UTF_8);
        System.out.println("传入参数为  " + req);
        if (req.equals("谚语")) {
            DatagramPacket newMsg = new DatagramPacket(Unpooled.copiedBuffer("谚语查询结果 " + nextQuote(), CharsetUtil.UTF_8), msg.sender());
            ctx.writeAndFlush(newMsg);
        }
    }


}
