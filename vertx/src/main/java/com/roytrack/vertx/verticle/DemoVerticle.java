package com.roytrack.vertx.verticle;

import io.vertx.core.AbstractVerticle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoVerticle extends AbstractVerticle {

  private Integer vId;

  private Long timerId;

  public DemoVerticle(Integer vId) {
    this.vId = vId;
  }

  @Override
  public void start() throws Exception {
    log.info("vid is {}, start working~", vId);
    timerId = vertx.setPeriodic(30_000, v -> {
      log.info("vid is {}, working~", vId);
    });
  }

  @Override
  public void stop() throws Exception {
    vertx.cancelTimer(timerId);
    log.info("vid is {}, stopped", vId);
  }

}
