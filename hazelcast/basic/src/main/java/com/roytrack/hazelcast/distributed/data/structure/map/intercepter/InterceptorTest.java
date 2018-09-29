package com.roytrack.hazelcast.distributed.data.structure.map.intercepter;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.map.MapInterceptor;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.assertEquals;

public class InterceptorTest {

  @Test
  public void testMapInterceptor() {
    HazelcastInstance hz1 = Hazelcast.newHazelcastInstance();
    HazelcastInstance hz2 = Hazelcast.newHazelcastInstance();
    IMap<Object, Object> map = hz1.getMap("testMapInterceptor");
    SimpleInterceptor simpleInterceptor = new SimpleInterceptor();
    String interceptorId = map.addInterceptor(simpleInterceptor);
    map.put(1, "New York");
    map.put(2, "Istanbul");
    map.put(3, "Tokyo");
    map.put(4, "London");
    map.put(5, "Paris");
    map.put(6, "Cairo");
    map.put(7, "Hong Kong");
    try {
      map.remove(1);
    } catch (Exception ignore) {
    }
    try {
      map.remove(2);
    } catch (Exception ignore) {
    }
    assertEquals(map.size(), 6);

    assertEquals(map.get(1), null);
    assertEquals(map.get(2), "ISTANBUL:");
    assertEquals(map.get(3), "TOKYO:");
    assertEquals(map.get(4), "LONDON:");
    assertEquals(map.get(5), "PARIS:");
    assertEquals(map.get(6), "CAIRO:");
    assertEquals(map.get(7), "HONG KONG:");


    map.removeInterceptor(interceptorId);

    map.put(8, "Moscow");


    assertEquals(map.get(8), "Moscow");
    assertEquals(map.get(1), null);
    assertEquals(map.get(2), "ISTANBUL");
    assertEquals(map.get(3), "TOKYO");
    assertEquals(map.get(4), "LONDON");
    assertEquals(map.get(5), "PARIS");
    assertEquals(map.get(6), "CAIRO");
    assertEquals(map.get(7), "HONG KONG");


  }

  static class SimpleInterceptor implements MapInterceptor, Serializable {

    @Override
    public Object interceptGet(Object value) {
      if (value == null) {
        return null;
      }
      return value + ":";
    }

    @Override
    public void afterGet(Object value) {

    }

    @Override
    public Object interceptPut(Object oldValue, Object newValue) {
      return newValue.toString().toUpperCase();
    }

    @Override
    public void afterPut(Object value) {

    }

    @Override
    public Object interceptRemove(Object removedValue) {
      if (removedValue.equals("ISTANBUL")) {
        throw new RuntimeException("you can not remove this");
      }
      return removedValue;
    }

    @Override
    public void afterRemove(Object value) {

    }
  }
}
