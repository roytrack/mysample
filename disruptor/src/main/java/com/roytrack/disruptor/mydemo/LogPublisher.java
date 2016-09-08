package com.roytrack.disruptor.mydemo;

import com.lmax.disruptor.RingBuffer;
import com.roytrack.dao.model.LogEntity;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by roytrack on 2016-09-08.
 */
@Service("logPublisher")
public class LogPublisher {
    private RingBuffer<LogEntity> ringBuffer;

    public LogPublisher(){
        super();
    }
    public void setRingBuffer(RingBuffer<LogEntity> ringBuffer){
        this.ringBuffer=ringBuffer;
    }
    public  RingBuffer<LogEntity> getRingBuffer(){
        return ringBuffer;
    }
    public LogPublisher(RingBuffer<LogEntity> ringBuffer){
        this.ringBuffer=ringBuffer;
    }
    public void publish(LogEntity log){
        long sequence=ringBuffer.next();
        try{
            LogEntity q=ringBuffer.get(sequence);
            BeanUtils.copyProperties(q,log);
//            q.setCustomerNo(log.getCustomerNo());
//            q.setAmount(log.getAmount());
//            q.setSheetNo(log.getSheetNo());
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            ringBuffer.publish(sequence);
        }

    }
}
