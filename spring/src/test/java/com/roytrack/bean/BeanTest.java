package com.roytrack.bean;

import com.roytrack.spring.core.bean.InstantiationBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by roytrack on 2015/2/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"classpath:bean/instantiationBean.xml"})
public class BeanTest {

    @Autowired
    private InstantiationBean ib;

    @Test
    public  void getConstructorBean(){
        System.out.println("name:"+ib.getName()+",sex:"+ib.getSex());
    }
}
