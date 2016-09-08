package com.roytrack.disruptor.startup;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;

/**
 * Created by roytrack on 2016-08-23.
 */
public class LongEventMainWithJava8Other {

    public static void handleEvent(LongEvent event,long sequence,boolean endOfBatch){
        System.out.println(event);
    }

    public static void translate(LongEvent event,long sequence,ByteBuffer buffer){
        event.setValue(buffer.getLong(0));
    }

    public static void main(String[] args) throws InterruptedException {
        int bufferSize=1024;
        Disruptor<LongEvent> disruptor=new Disruptor<LongEvent>(LongEvent::new,bufferSize, DaemonThreadFactory.INSTANCE);

        disruptor.handleEventsWith(LongEventMainWithJava8Other::handleEvent);

        disruptor.start();

        RingBuffer<LongEvent> ringBuffer=disruptor.getRingBuffer();

        ByteBuffer bb=ByteBuffer.allocate(8);
        for(long l=0;true;l++){
            bb.putLong(0,l);
            ringBuffer.publishEvent(LongEventMainWithJava8Other::translate, bb);
            Thread.sleep(1000);
        }
    }


}
