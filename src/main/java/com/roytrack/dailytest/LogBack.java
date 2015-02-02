package com.roytrack.dailytest;

import ch.qos.logback.classic.LoggerContext;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ruanchangming on 2015/1/31.
 */
public class LogBack {
    Logger logger= LoggerFactory.getLogger(LogBack.class);

    @Test
    public void seeLogStatus(){
        LoggerContext lc=(LoggerContext) LoggerFactory.getILoggerFactory();
        System.out.println(lc);
    }
}
