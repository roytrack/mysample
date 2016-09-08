package com.roytrack;

import com.roytrack.disruptor.mydemo.NormalBusiness;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.NoSuchAlgorithmException;

/**
 * Created by roytrack on 2016-09-08.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class InjectTest {
    @Autowired
    ApplicationContext context;
    @Test
    public void inject() throws NoSuchAlgorithmException {
        NormalBusiness b=context.getBean("normalBusiness", NormalBusiness.class);
        b.insertLog();
    }
}
