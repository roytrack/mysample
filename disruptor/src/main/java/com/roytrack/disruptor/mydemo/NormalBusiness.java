package com.roytrack.disruptor.mydemo;

import com.roytrack.dao.model.LogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by roytrack on 2016-09-08.
 */
@Service("normalBusiness")
public class NormalBusiness {

    @Autowired
    LogPublisher logPublisher;


    public void insertLog() throws NoSuchAlgorithmException {
        for(int i=0;i<1000;i++){
            LogEntity entity=new LogEntity();
            entity.setSheetNo(String.valueOf(i));
            entity.setAmount(new BigDecimal(SecureRandom.getInstanceStrong().nextDouble()));
            entity.setCustomerNo(String.valueOf(SecureRandom.getInstanceStrong().nextLong()));
            logPublisher.publish(entity);
            System.out.println("put " + i + " entity ");
            System.out.println(logPublisher.getRingBuffer().getCursor());
            System.out.println(logPublisher.getRingBuffer().getMinimumGatingSequence());
            //Thread.sleep(1000);
        }
    }

}


