package com.roytrack.netty.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * Created by roytrack on 2016-10-24.
 */
public class ProtoBufSeeBean {
    public static void main(String[] args) throws InvalidProtocolBufferException {
        SubscribeReqC.SubscribeReq req= SubscribeReqC.SubscribeReq.getDefaultInstance();
        req=req.toBuilder().setUserName("roytrack").setProductName("netty 权威指南").setAddress("中国北京").setSubReqid(10).build();
        System.out.println(req.toByteString().toStringUtf8());

        SubscribeReqC.SubscribeReq returnReq= SubscribeReqC.SubscribeReq.parseFrom(req.toByteArray());
        System.out.println(returnReq.toString());
        System.out.println(returnReq.getAddress());
    }
}
