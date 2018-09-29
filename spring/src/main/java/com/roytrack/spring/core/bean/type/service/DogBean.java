package com.roytrack.spring.core.bean.type.service;

import com.roytrack.spring.core.bean.type.Man;
import org.springframework.stereotype.Service;

/**
 * Created by roytrack on 2015/8/24.
 */
@Service
public class DogBean extends AnimalBean<Man> {
  @Override
  public void saySomething(Man t) {
    System.out.println("man say");
  }
}
