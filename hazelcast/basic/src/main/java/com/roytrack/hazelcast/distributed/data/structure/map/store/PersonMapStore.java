package com.roytrack.hazelcast.distributed.data.structure.map.store;

import com.hazelcast.core.MapStore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class PersonMapStore implements MapStore<Long, Person> {

  private final Connection con;

  public PersonMapStore() {
    try {
      con = DriverManager.getConnection("jdbc:hsqldb:mydatabase", "SA", "");
      ((java.sql.Connection) con).createStatement().executeUpdate(
              "create table if not exists person (id bigint, name varchar(45))"
      );
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public void store(Long key, Person value) {
    try {
      con.createStatement().executeUpdate(format("insert into person values (%s,'%s')", key, value));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void storeAll(Map<Long, Person> map) {
    for (Map.Entry<Long, Person> entry : map.entrySet()) {
      store(entry.getKey(), entry.getValue());
    }
  }

  @Override
  public void delete(Long key) {
    System.out.println("Delete: " + key);
    try {
      con.createStatement().executeUpdate(format("delete from person where id = %s", key));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void deleteAll(Collection<Long> keys) {
    for (Long key : keys) {
      delete(key);
    }
  }

  @Override
  public Person load(Long key) {
    ResultSet resultSet = null;
    try {
      resultSet = con.createStatement().executeQuery(format("select name from person where id = %s", key));
      if (!resultSet.next()) {
        return null;
      }
      String name = resultSet.getString(1);
      return new Person(key, name);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      if (resultSet != null) {
        try {
          resultSet.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }

  @Override
  public Map<Long, Person> loadAll(Collection<Long> keys) {
    Map<Long, Person> result = new HashMap<>();
    for (Long key : keys) {
      result.put(key, load(key));
    }
    return result;
  }

  @Override
  public Iterable<Long> loadAllKeys() {
    return null;
  }
}
