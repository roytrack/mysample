package com.roytrack.dailytest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class SpringGetPlaceHolderBeanName {
  public static void main(String[] args) {
    ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:abc.xml");
    for (String beanName : ac.getBeanDefinitionNames()) {
      System.out.print(beanName + "\t");
    }

  }
}
