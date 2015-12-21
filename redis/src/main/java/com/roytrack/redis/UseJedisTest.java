package com.roytrack.redis;

import redis.clients.jedis.Jedis;

/**
 * 直接写jedis 进行三个操作 3493ms 执行1000次
 * Created by ruanchangming on 2015/12/21.
 */
public class UseJedisTest {
    static String host="10.58.69.142";
    static int port=6379;

    public static void main(String[] args) {
        Jedis j=new Jedis(host,port);
//        logger.info("开始{}",new Date());\

        long start=System.currentTimeMillis();
        System.out.println(start);
        for(int i=0;i<1000;i++){
            j.set("roy", "111");
            j.get("roy");
            j.del("roy");
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
//        logger.info("结束{}",new Date());

    }


}
