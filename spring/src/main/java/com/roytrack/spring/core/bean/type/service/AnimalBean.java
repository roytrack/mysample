package com.roytrack.spring.core.bean.type.service;

import org.springframework.stereotype.Service;

/**
 * Created by roytrack on 2015/8/24.
 */
@Service
public class AnimalBean<T> {

  public void saySomething(T t) {
    System.out.println("nothing");
  }
}
