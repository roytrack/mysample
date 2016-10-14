package com.roytrack.bean.type;

import com.roytrack.spring.core.bean.type.Human;
import com.roytrack.spring.core.bean.type.Man;
import com.roytrack.spring.core.bean.type.Woman;
import com.roytrack.spring.core.bean.type.service.AnimalBean;
import com.roytrack.spring.core.bean.type.service.BaseBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.regex.Pattern;

/**
 * Created by roytrack on 2015/8/24.
 */@RunWith(SpringJUnit4ClassRunner.class)
   @ContextConfiguration(locations = {"classpath:bean/typeBean.xml"})
public class TypeTest {
    @Autowired
    AnimalBean animalBean;
    @Autowired
    AnimalBean dogBean;
    @Autowired
    AnimalBean catBean;
    @Autowired
    private ApplicationContext ctx;
    @Test
    public  void seeWhatHappen(){
        String[] a= ctx.getBeanDefinitionNames();

        for(String c:a){
            System.out.println(c);
        }
        Human human=new Human();
        Man man=new Man();
        animalBean.saySomething(man);
        Woman woman=new Woman();
        dogBean.saySomething(man);

        catBean.saySomething(woman);
    }
}
