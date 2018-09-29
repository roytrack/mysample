package com.roytrack.disruptor.startup;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import org.junit.Test;

/**
 * demo for learn disruptor
 * <p>
 * Created by roytrack on 2016-08-22.
 */
public class MyfirstDisruptor {

  EventFactory<LongEvent> factory = new LongEventFactory();
  LongEventHandler handler = new LongEventHandler();

  @Test
  public void useDisruptor() {
    Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory, 1024, DaemonThreadFactory.INSTANCE);
    disruptor.handleEventsWith(handler);
  }

}
