package com.roytrack.disruptor.startup;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created by roytrack on 2016-08-22.
 */
public class LongEventProducer {
  private final RingBuffer<LongEvent> ringBuffer;

  public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
    this.ringBuffer = ringBuffer;
  }

  public void onData(ByteBuffer bb) {
    long sequence = ringBuffer.next();
    try {
      LongEvent event = ringBuffer.get(sequence);
      event.setValue(bb.getLong(0));
    } finally {
      ringBuffer.publish(sequence);
    }
  }
}
