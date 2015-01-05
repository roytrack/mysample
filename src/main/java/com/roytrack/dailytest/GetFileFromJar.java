package com.roytrack.dailytest;

import org.springside.modules.nosql.redis.JedisScriptExecutor;
import org.springside.modules.nosql.redis.pool.JedisPool;
import org.springside.modules.nosql.redis.pool.JedisPoolBuilder;

/**
 * Created by ruanchangming on 2015/1/5.
 */
public class GetFileFromJar {
    public static void main(String[] args) {
          String importLuaScript="classpath*:/script/belum/import.lua";
      JedisPool pool = new JedisPoolBuilder()
                .setUrl("sentinel://10.100.90.46:26379?masterName=mymaster&database=0&poolSize=100&poolName=my").buildPool();
        MyJedisScriptExecutor jse=new MyJedisScriptExecutor(pool);
        jse.loadFromFile(importLuaScript);
        System.exit(0);
    }
}
