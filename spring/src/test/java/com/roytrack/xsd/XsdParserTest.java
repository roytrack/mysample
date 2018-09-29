package com.roytrack.xsd;

import com.roytrack.spring.custiomize.xml.PersonVo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by roytrack on 2015/5/22.
 */

public class XsdParserTest {

  /***
   * spring xml customized
   *
   * every element need a parser
   * so just make one element and several attribute
   *
   * */
  @Test
  public void readCustomizedXml() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:customizedXSD/roy.xml");
    PersonVo p = (PersonVo) ctx.getBean("roy");
    System.out.println(p);


  }
}
