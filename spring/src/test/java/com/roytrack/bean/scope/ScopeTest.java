package com.roytrack.bean.scope;

import com.roytrack.spring.core.bean.scope.OtherSingleTonBean;
import com.roytrack.spring.core.bean.scope.PrototypeBean;
import com.roytrack.spring.core.bean.scope.SingleTonBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by roytrack on 2016-08-03.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean/scopeTest.xml")
public class ScopeTest {

  @Autowired
  ApplicationContext context;

  @Test
  public void showSingleTon() {
    PrototypeBean pb = context.getBean("prototypeBean", PrototypeBean.class);
    System.out.println(pb + "  name " + pb.getName() + "  age " + pb.getAge());
    SingleTonBean b = context.getBean("singleTonBean", SingleTonBean.class);
    b.showBean();
    b = context.getBean("singleTonBean", SingleTonBean.class);
    b.setBean(pb);
    b.showBean();
    OtherSingleTonBean ot = context.getBean("otherSingleTonBean", OtherSingleTonBean.class);
    ot.showBean();

  }

}
