package com.roytrack.bean;

import com.roytrack.spring.core.bean.FirstBean;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import static org.junit.Assert.assertEquals;

/**
 * Created by roytrack on 2015/5/6.
 */
public class BeanFactoryTest {

    @Test
    public void testSimpleLoad(){
        BeanFactory bf=new XmlBeanFactory(new ClassPathResource("bean/beanFactoryTest.xml"));
        FirstBean bean=(FirstBean)bf.getBean("myTestBean");
        assertEquals("testStr",bean.getTestStr());
    }
}
