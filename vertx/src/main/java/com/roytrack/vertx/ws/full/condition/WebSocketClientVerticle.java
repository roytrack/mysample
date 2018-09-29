package com.roytrack.vertx.ws.full.condition;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.MultiMap;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.impl.headers.VertxHttpHeaders;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author roytrack
 * @time 2018/6/25 下午2:07
 */

@Slf4j
public class WebSocketClientVerticle extends AbstractVerticle {

  @Getter
  @Setter
  private String host;
  @Getter
  @Setter
  private int port;

  private AtomicBoolean alreadySleep = new AtomicBoolean(false);

  @Override
  public void start() {
    try {
      HttpClient httpClient = vertx.createHttpClient(new HttpClientOptions().setSsl(false)
              .setTryUseCompression(true));
      MultiMap multiMap = new VertxHttpHeaders();
      ((VertxHttpHeaders) multiMap).set("a", "ccc");
      httpClient.websocket(port, host, "/abcd", websocket -> {
        websocket.textMessageHandler(h -> {
          log.info("receive data is {}", h);
          sleep();
        });
        websocket.exceptionHandler(e -> {
          log.error("websocket client exception is :", e);
        });

        websocket.writeTextMessage("43434");
//                vertx.setPeriodic(32_0000L,h->{
//                    sleep();
//                });
      }, fail -> {
        log.error("httpclient failed :", fail);
      });
    } catch (Throwable e) {
      log.error("client error:", e);
    }

  }

  private void sleep() {
    try {
      log.info("begin sleep" + "   " + Instant.now().toEpochMilli());
      if (!alreadySleep.get()) {
        alreadySleep.set(true);
        Thread.sleep(30_000L);
      }
      alreadySleep.set(false);
      log.info("I'm wake" + "   " + Instant.now().toEpochMilli());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}




