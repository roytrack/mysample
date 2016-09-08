package com.roytrack.disruptor.mydemo;

import com.lmax.disruptor.EventHandler;
import com.roytrack.dao.mapper.LogEntityMapper;
import com.roytrack.dao.model.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by roytrack on 2016-09-08.
 */
@Service("logHandler")
public class LogHandler implements EventHandler<LogEntity> {

    @Autowired
    LogEntityMapper logEntityMapper;

    @Override
    public void onEvent(LogEntity event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("====="+event.toString());
        System.out.println(endOfBatch);
        logEntityMapper.insert(event);
    }
}
