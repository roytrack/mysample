package com.roytrack.dailytest.commmons_beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

/**
 * Created by roytrack on 2016-08-25.
 */
public class BeanutilsDemo {

  @Test
  public void copyProperties() throws InvocationTargetException, IllegalAccessException {
    Abean a = new Abean();
    a.setAmount(new BigDecimal(55));
    a.setSubject("abc");
    BBean b = new BBean();
    b.setName("roy");
    a.setBBean(b);
    Abean a1 = new Abean();
    BeanUtils.copyProperties(a1, a);
    System.out.println(a);
    System.out.println(a1);
    a.setSubject("ddd");
    a.setAmount(new BigDecimal(66));
    System.out.println(a);
    System.out.println(a1);
  }
}
