package com.roytrack.spring.core.transaction;

import com.roytrack.spring.core.transaction.demo.AService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by roytrack on 2015/1/29.
 */
public class TransactionExampleTest {
    static  ApplicationContext   ac;
    @BeforeClass
    public static void setUpClass() {
          ac=new ClassPathXmlApplicationContext("classpath:spring-transaction.xml");
    }

    @Test
    public void abc(){
       cc();
    }
    public void cc(){
        AService as= ac.getBean(AService.class);
        as.update();

    }
}
