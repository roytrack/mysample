package com.roytrack.disruptor.startup;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created by roytrack on 2016-08-23.
 */
public class LongEventProducerWithTranslator {

    private final RingBuffer<LongEvent> ringBuffer;
    public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer){
        this.ringBuffer=ringBuffer;
    }
    private static final EventTranslatorOneArg<LongEvent,ByteBuffer> TRANSLATOR=new EventTranslatorOneArg<LongEvent, ByteBuffer>() {
        @Override
        public void translateTo(LongEvent event, long sequence, ByteBuffer arg0) {
            event.setValue(arg0.getLong());
        }
    };
    public void onData(ByteBuffer bb){
        ringBuffer.publishEvent(TRANSLATOR,bb);
    }
}
