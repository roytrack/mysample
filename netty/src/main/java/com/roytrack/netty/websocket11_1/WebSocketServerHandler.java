package com.roytrack.netty.websocket11_1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.CharsetUtil;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by roytrack on 2017-03-24.
 */
public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {

  private static final Logger logger = Logger.getLogger(WebSocketServerHandler.class.getName());

  private WebSocketServerHandshaker handshaker;

  private static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, FullHttpResponse resp) {
    if (resp.status().code() != 200) {
      ByteBuf buf = Unpooled.copiedBuffer(resp.status().toString(), CharsetUtil.UTF_8);
      resp.content().writeBytes(buf);
      buf.release();
      HttpUtil.setContentLength(resp, resp.content().readableBytes());
    }

    ChannelFuture f = ctx.channel().writeAndFlush(resp);
    if (!HttpUtil.isKeepAlive(req) || resp.status().code() != 200) {
      f.addListener(ChannelFutureListener.CLOSE);
    }
  }

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, Object msg) {

    if (msg instanceof FullHttpRequest) {
      handleHttpRequest(ctx, (FullHttpRequest) msg);
    } else if (msg instanceof WebSocketFrame) {
      handleWebSocketFrame(ctx, (WebSocketFrame) msg);
    }


  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) {
    ctx.flush();
  }

  private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) {
    if ((!req.decoderResult().isSuccess()) || (!"websocket".equals(req.headers().get("Upgrade")))) {
      sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
      return;
    }
    WebSocketServerHandshakerFactory factory = new WebSocketServerHandshakerFactory("ws://10.87.156.46:8080/websocket", null, false);
    handshaker = factory.newHandshaker(req);
    if (handshaker == null) {
      WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
    } else {
      handshaker.handshake(ctx.channel(), req);
    }
  }

  private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
    if (frame instanceof CloseWebSocketFrame) {
      handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
    }
    if (frame instanceof PingWebSocketFrame) {
      ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
      return;
    }
    if (!(frame instanceof TextWebSocketFrame)) {
      throw new UnsupportedOperationException(String.format("% frame types not supported", frame.getClass().getName()));
    }
    String request = ((TextWebSocketFrame) frame).text();
    if (logger.isLoggable(Level.FINE)) {
      logger.fine(String.format("%s recevied %s", ctx.channel(), request));
    }
    ctx.channel().write(new TextWebSocketFrame(request + ",欢迎使用Netty WebSocket服务，现在时刻：" + LocalDateTime.now().toString()));
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    cause.printStackTrace();
    ctx.close();
  }


}

