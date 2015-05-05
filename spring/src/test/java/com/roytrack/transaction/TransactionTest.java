package com.roytrack.transaction;

import com.roytrack.spring.transaction.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by roytrack on 2015/5/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/transaction/application.xml"})
public class TransactionTest {
    @Resource
    MyService myService;

    @Test
    public void CrossWithMysqlTransaction(){
        myService.makeCrossTransaction();
    }

    @Test
    public void crossWithMysqlOracle(){
        myService.makeCrossTransactionWithOracleMysql();
    }


}
