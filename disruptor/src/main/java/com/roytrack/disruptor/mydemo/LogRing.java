package com.roytrack.disruptor.mydemo;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import com.roytrack.dao.model.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


/**
 * Created by roytrack on 2016-09-08.
 */
@Service("logRing")
public class LogRing {

    @Autowired
    ApplicationContext context;
    private Disruptor<LogEntity> disruptor;



    @PostConstruct
    public void start(){
        int bufferSize=512;
         disruptor=new Disruptor<LogEntity>(LogEntity::new,bufferSize,DaemonThreadFactory.INSTANCE);
        disruptor.handleEventsWith(context.getBean("logHandler",LogHandler.class));
        RingBuffer<LogEntity> ringBuffer=disruptor.getRingBuffer();
        LogPublisher logPublisher=context.getBean("logPublisher", LogPublisher.class);
        logPublisher.setRingBuffer(ringBuffer);
        disruptor.start();
    }
    @PreDestroy
    public void stop(){
        disruptor.shutdown();
    }
    public static void main(String[] args) throws NoSuchAlgorithmException, InterruptedException {
        int bufferSize=512;
        Disruptor<LogEntity> disruptor=new Disruptor<LogEntity>(LogEntity::new,bufferSize,DaemonThreadFactory.INSTANCE);
        disruptor.handleEventsWith(new LogHandler());
        RingBuffer<LogEntity> ringBuffer=disruptor.getRingBuffer();
        LogPublisher logPublisher=new LogPublisher(ringBuffer);
        disruptor.start();
        for(int i=0;i<1000;i++){
            LogEntity entity=new LogEntity();
            entity.setSheetNo(String.valueOf(i));
            entity.setAmount(new BigDecimal(SecureRandom.getInstanceStrong().nextDouble()));
            entity.setCustomerNo(String.valueOf(SecureRandom.getInstanceStrong().nextLong()));
            logPublisher.publish(entity);
            System.out.println("put " + i + " entity ");
            System.out.println(ringBuffer.getCursor());
            System.out.println(ringBuffer.getMinimumGatingSequence());
            //Thread.sleep(1000);
        }
        disruptor.shutdown();


    }
}
