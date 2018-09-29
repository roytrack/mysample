package com.roytrack.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * 直接写jedis 进行三个操作 3493ms 执行1000次
 * 在使用pipeline之后同样操作执行10w次只需要740ms
 * 单次执行1.19ms
 * Created by roytrack on 2015/12/21.
 */
public class UseJedisTest {
  static String host = "10.58.69.142";
  static int port = 6379;

  public static void main(String[] args) {
    JedisPool pool = new JedisPool(host, port);
    Jedis j = pool.getResource();
//        logger.info("开始{}",new Date());\

    long start = System.nanoTime();
    System.out.println(start);
//        for(int i=0;i<1000;i++){
//            j.set("roy", "111");
//            j.get("roy");
//            j.del("roy");
//        }
    long end = System.nanoTime();
    System.out.println(end - start);
//        logger.info("结束{}",new Date());

    Pipeline pipeline = j.pipelined();
    start = System.nanoTime();
    Response<String> response;
    List<Response<String>> result = new ArrayList<>();
    System.out.println(start);
    for (int i = 0; i < 100000; i++) {
      response = pipeline.set("roy", "111");
      result.add(response);
      response = pipeline.get("roy");
      result.add(response);
      pipeline.del("roy");
    }
    end = System.nanoTime();
    System.out.println(end - start);
    pipeline.sync();
    System.out.println("result size " + result.size());
//        pipeline=j.pipelined();
    start = System.nanoTime();
    response = pipeline.set("roy", "111");
    pipeline.sync();
    end = System.nanoTime();
    System.out.println(end - start);
    System.out.println(response.get());

  }


}
