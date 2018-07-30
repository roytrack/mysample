package com.roytrack.hazelcast;

import java.io.Serializable;

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

    public Customer clone(Customer c) {
        Customer newOne = new Customer(c.getId());
        newOne.setAge(c.getAge());
        newOne.setName(c.getName());
        return newOne;
    }

}
