package com.roytrack.spring.custiomize.xml;

import lombok.ToString;

/**
 * Created by roytrack on 2015/5/22.
 */
@ToString
public class PersonVo {
  private String id;
  private String thename;
  private int age;
  private String address;

  public String getThename() {
    return thename;
  }

  public void setThename(String thename) {
    this.thename = thename;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
