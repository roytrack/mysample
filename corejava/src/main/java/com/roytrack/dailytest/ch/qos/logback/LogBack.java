package com.roytrack.dailytest.ch.qos.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by roytrack on 2015/1/31.
 */
public class LogBack {
    Logger logger= LoggerFactory.getLogger(LogBack.class);




    @Test
    public void seeLogStatus(){
        logger.info("logger start .....");
        LoggerContext lc=(LoggerContext) LoggerFactory.getILoggerFactory();
        System.out.println(lc);
        StatusPrinter.print(lc);
        logger.error("logger end .....",new NullPointerException("asasdasd"));
    }
}