package com.roytrack.spring.core.bean.type.service;

import com.roytrack.spring.core.bean.type.Woman;
import org.springframework.stereotype.Service;

/**
 * Created by roytrack on 2015/8/24.
 */
@Service
public class CatBean extends AnimalBean<Woman> {

  @Override
  public void saySomething(Woman t) {
    System.out.println("woman say");
  }
}
