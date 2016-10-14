package com.roytrack.mybatis;

import com.roytrack.mybatis.mapper.AbcMapper;
import com.roytrack.mybatis.model.Abc;
import com.roytrack.mybatis.service.MyNameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by roytrack on 2015/12/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class SpecialSymbolTest {
    @Resource
    MyNameService myService;

    @Autowired
    AbcMapper abcMapper;

    @Test
    public void abc(){
        List<String> as=abcMapper.selectID();
        System.out.println(as.size());
    }

    @Test
    public void specialSymbol(){
        myService.insert();
    }

    @Test
    public  void selectIn(){
        List<Abc> list= myService.selectIn();
//        System.out.println(list.size());
//        for(Abc c:list){
//            System.out.println(c);
//        }
        list=myService.selectIn2();
        for(Abc c:list){
            System.out.println(c);
        }
    }

    @Test
    public  void selectID(){
        List<String> list= myService.selectId();
        System.out.println(list.size());
        for(String c:list){
            System.out.println(c);
        }

    }
}
