package com.roytrack.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by roytrack on 2016-08-23.
 */
public class LongEventMain {
    public static void main(String[] args) throws InterruptedException {

        Executor executor= Executors.newCachedThreadPool();

        LongEventFactory factory=new LongEventFactory();

        int bufferSize=1024;

        Disruptor<LongEvent> disruptor=new Disruptor<LongEvent>(factory,bufferSize,executor);

        disruptor.handleEventsWith(new LongEventHandler());

        disruptor.start();

        RingBuffer<LongEvent> ringBuffer=disruptor.getRingBuffer();

        LongEventProducer producer=new LongEventProducer(ringBuffer);

        ByteBuffer bb=ByteBuffer.allocate(8);

        for(long l=0l;true;l++){

            bb.putLong(0,l);
            producer.onData(bb);
            Thread.sleep(1000);
        }
    }
}
