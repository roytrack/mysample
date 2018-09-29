package com.roytrack.hazelcast.distributed.data.structure.map.listener;

import java.io.Serializable;

public class Employee implements Serializable {
  private final String surname;

  public Employee(String surname) {
    this.surname = surname;
  }

  @Override
  public String toString() {
    return "Employee{" +
            "surname='" + surname + '\'' +
            '}';
  }
}
