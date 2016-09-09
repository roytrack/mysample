package com.roytrack.aspect;

import com.roytrack.spring.aspect.AnnotationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by roytrack on 2016-09-08.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aspect/aop3.xml")
public class AspectTest3 {

    @Autowired
    ApplicationContext context;

    @Test
    public void showAspect(){
        AnnotationService t=context.getBean("annotationService", AnnotationService.class);
        t.say();
        t.sayWithParam("ccc");
    }
}
