package com.roytrack.aspect;

import com.roytrack.spring.aspect.TargetService;
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
@ContextConfiguration("classpath:aspect/aop.xml")
public class AspectTest {

  @Autowired
  ApplicationContext context;

  @Test
  public void showAspect() {
    TargetService t = context.getBean("targetService", TargetService.class);
    t.saySomething("go go go ");
  }
}
