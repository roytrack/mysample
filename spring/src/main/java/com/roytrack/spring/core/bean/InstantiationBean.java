package com.roytrack.spring.core.bean;

import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

/**
 * Created by roytrack on 2015/2/7.
 */
@Getter
@Setter
public class InstantiationBean {

  private String name;
  private String sex;

  @ConstructorProperties({"name", "sex"})
  public InstantiationBean(String name, String sex) {
    this.name = name;
    this.sex = sex;
  }
}
