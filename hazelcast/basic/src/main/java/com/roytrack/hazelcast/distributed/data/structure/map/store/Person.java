package com.roytrack.hazelcast.distributed.data.structure.map.store;

import java.io.Serializable;

public class Person implements Serializable {
  private Long id;
  private String name;

  public Person(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
