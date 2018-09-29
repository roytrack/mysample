package com.roytrack.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by roytrack on 2016-08-25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class UseSpringTemplate {

  @Autowired
  RedisTemplate redisTemplate;
  private String hash = "1212";
  private String key = "bbb";

  @Test
  public void hashIncrement() {
//        redisTemplate.opsForHash().put(hash,key,5.44d);
    redisTemplate.opsForHash().increment(hash, key, 2.2d);
  }


}
