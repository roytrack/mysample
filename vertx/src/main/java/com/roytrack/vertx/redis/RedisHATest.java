package com.roytrack.vertx.redis;

import com.google.common.collect.Lists;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.reactivex.redis.RedisClient;
import io.vertx.redis.RedisOptions;
import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class RedisHATest extends AbstractVerticle {

  private final static String lockScript = "local result = redis.call('get', KEYS[1])\n" +
          "if\n" +
          "  result == ARGV[1]\n" +
          "then\n" +
          "  redis.call(\"expire\",KEYS[1],60)\n" +
          "  return ARGV[1]\n" +
          "elseif result == false or result == nil\n" +
          "then\n" +
          "  local setSuccess = redis.call(\"set\",KEYS[1],ARGV[1],\"EX\",60,\"NX\")\n" +
          "  if setSuccess == \"OK\"\n" +
          "  then\n" +
          "    return ARGV[1]\n" +
          "  else\n" +
          "    local t = type(setSuccess)\n" +
          "    if t == \"table\"\n" +
          "    then\n" +
          "     local concatStr = \"-3\"\n" +
          "     for k,v in pairs(setSuccess) do\n" +
          "       concatStr = concatStr..\"|\"..tostring(k)..\"=\"..tostring(v)\n" +
          "     end\n" +
          "     return concatStr\n" +
          "    else\n" +
          "     return \"-2\"..tostring(setSuccess) \n" +
          "    end \n" +
          "  end \n" +
          "else\n" +
          "  return result\n" +
          "end";

  public static void main(String[] args) throws InterruptedException {
    log.info(lockScript);
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new RedisHATest());
    log.info(" {}  one verticle deploy begin ,let's wait 10s", Thread.currentThread().getName());
    for (int i = 0; i < 10; i++) {
      Thread.sleep(1_000);
      vertx.deployVerticle(new RedisHATest());
    }

    while (true) {
      Thread.sleep(10_000);
      log.info(" {}  for verticle run ,sleep by 10s periodic", Thread.currentThread().getName());
    }
  }

  @Override
  public void start(Future<Void> startFuture) {
    String patternStr = "vert\\.x-eventloop-thread-(\\d+)";
    Pattern pattern = Pattern.compile(patternStr);
    RedisOptions options = new RedisOptions();
    options.setHost("localhost").setPort(6379).setSelect(1);
    io.vertx.reactivex.core.Vertx rx = new io.vertx.reactivex.core.Vertx(vertx);
    RedisClient client = RedisClient.create(rx, options);
    final StringBuffer scriptSHA = new StringBuffer();
    client.scriptLoad(lockScript, v -> {
      if (v.succeeded()) {
        scriptSHA.append(v.result());
        log.info("load script result is {}", v.result());
      } else {
        log.error("load script error {}", v.cause());
      }


    });
    vertx.setPeriodic(10_000, p -> {
      String thread = Thread.currentThread().getName();
      Matcher matcher = pattern.matcher(thread);
      String threadNum = "";
      if (matcher.find()) {
        threadNum = matcher.group(1);
      }
      final String threadNumStr = threadNum;
      final String sha = scriptSHA.toString();
      client.evalsha(sha,
              Lists.newArrayList("roytrack"), Lists.newArrayList(threadNumStr), v -> {
                if (v.succeeded()) {
                  log.info("thread is {}, set redis roytrack is {}", threadNumStr, v.result());
                } else {
                  log.error("thread is {}, set redis error is {}", threadNumStr, v.cause());
                }

              });
    });

  }
}
