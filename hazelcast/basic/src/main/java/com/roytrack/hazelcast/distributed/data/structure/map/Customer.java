package com.roytrack.hazelcast.distributed.data.structure.map;

import java.io.Serializable;
import java.util.Objects;


public class Customer implements Serializable {
  private String id;
  private String name;
  private Integer age;

  public Customer(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public static Customer clone(Customer c) {
    Customer newOne = new Customer(c.getId());
    newOne.setAge(c.getAge());
    newOne.setName(c.getName());
    return newOne;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer customer = (Customer) o;
    return Objects.equals(id, customer.id) &&
            Objects.equals(name, customer.name) &&
            Objects.equals(age, customer.age);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, name, age);
  }

  @Override
  public String toString() {
    return "id is " + id + " ,age is " + age + " ,name is " + name;
  }

}
