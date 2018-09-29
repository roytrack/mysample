package com.roytrack.dailytest.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roytrack.dailytest.jackson.model.AClass;
import com.roytrack.dailytest.jackson.model.CClass;

import java.io.IOException;

/**
 * Created by roytrack on 2016-12-09.
 */
public class JacksonDemo {
  public static void main(String[] args) throws IOException {
    ObjectMapper m = new ObjectMapper();
    CClass c = new CClass();
    c.setChannelId(11);
    c.setAreaName("北京");
    AClass a = new AClass();
    a.setCClass(c);
    a.setOrderId("2222");
    String result1 = m.writeValueAsString(a);
    System.out.println(result1);

    c.setChannelId(null);
    c.setAreaName(null);

    c.setMovieId(123123);
    c.setMovieName("54568");
    result1 = m.writeValueAsString(a);
    System.out.println(result1);

    String json1 = "{\"orderId\":\"2222\",\"cclass\":{\"areaName\":\"北京\",\"channelId\":11,\"movieName\":null,\"movieId\":null}}";
    String json2 = "{\"orderId\":\"2222\",\"cclass\":{\"areaName\":null,\"channelId\":null,\"movieName\":\"54568\",\"movieId\":123123}}";
    AClass json1A = m.readValue(json1, AClass.class);
    AClass json2A = m.readValue(json2, AClass.class);

    System.out.println(json1A);
    System.out.println(json2A);

  }
}
