package com.roytrack.disruptor.startup;

import com.lmax.disruptor.EventHandler;

/**
 * Created by roytrack on 2016-08-22.
 */
public class LongEventHandler implements EventHandler<LongEvent> {
  @Override
  public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
    System.out.println("event" + longEvent);
  }
}
