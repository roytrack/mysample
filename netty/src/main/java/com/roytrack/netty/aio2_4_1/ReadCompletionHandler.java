package com.roytrack.netty.aio2_4_1;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

/**
 * Created by ruanchangming on 2016-3-25.
 */
public class ReadCompletionHandler implements CompletionHandler<Integer,  ByteBuffer> {

    private AsynchronousSocketChannel channel;

    public ReadCompletionHandler(AsynchronousSocketChannel result) {
        if(this.channel==null)
        this.channel=result;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte [] body=new byte[attachment.remaining()];
        attachment.get(body);
        try{
            String req=new String(body,"UTF-8");
            System.out.println(" this time server received order : "+req);
            String currentTime="time".equalsIgnoreCase(req)?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
            doWrite(currentTime);
        }catch (UnsupportedEncodingException e){

        }


    }

    private void doWrite(String currentTime) {
        if(currentTime!=null&&currentTime.trim().length()>0){
            byte [] bytes=currentTime.getBytes();
            ByteBuffer byteBuffer=ByteBuffer.allocate(bytes.length);
            byteBuffer.put(bytes);
            byteBuffer.flip();
            channel.write(byteBuffer, byteBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    if(attachment.hasRemaining()){
                        channel.write(attachment,attachment,this);
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        channel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
