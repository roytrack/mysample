package com.roytrack.mybatis;

import com.roytrack.mybatis.service.MyNameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by ruanchangming on 2015/12/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class SpecialSymbolTest {
    @Resource
    MyNameService myService;

    @Test
    public void specialSymbol(){
        myService.insert();
    }
}
