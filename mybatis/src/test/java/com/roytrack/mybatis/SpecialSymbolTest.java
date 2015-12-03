package com.roytrack.mybatis;

import com.roytrack.mybatis.model.Abc;
import com.roytrack.mybatis.service.MyNameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

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

    @Test
    public  void selectIn(){
        List<Abc> list= myService.selectIn();
        System.out.println(list.size());
        for(Abc c:list){
            System.out.println(c);
        }

    }
}
