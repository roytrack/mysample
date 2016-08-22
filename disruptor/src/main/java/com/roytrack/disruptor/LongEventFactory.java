package com.roytrack.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by roytrack on 2016-08-22.
 */
public class LongEventFactory   implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
