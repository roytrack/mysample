package com.roytrack.spring.core.bean.scope;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by roytrack on 2016-08-03.
 */
@Service
@Getter
@Setter
public class OtherSingleTonBean {

  @Autowired
  PrototypeBean bean;

  public void showBean() {
    System.out.println("@@" + bean + "  name " + bean.getName() + "  age " + bean.getAge());
  }
}
