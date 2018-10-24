package com.roytrack.vertx.verticle;

import io.vertx.core.Vertx;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class DynamicDeployVerticleDemo {
  public static void main(String[] args) throws InterruptedException {
    Vertx vertx = Vertx.vertx();
    AtomicInteger integer = new AtomicInteger();
    CopyOnWriteArrayList<String> deploymentIdList = new CopyOnWriteArrayList<>();
    for (int i = 0; i < 10; i++) {
      vertx.deployVerticle(new DemoVerticle(i), v -> {
        log.info("deploy result is {}", v.result());
        deploymentIdList.add(v.result());
        integer.incrementAndGet();
      });
    }
    while (integer.get() < 10) {
      Thread.sleep(100);
    }
    for (int i = 0; i < deploymentIdList.size(); i++) {
      if (i % 2 == 0) {
        String deploymentId = deploymentIdList.get(i);
        vertx.undeploy(deploymentId, v -> {
          log.info("undeploy verticle {}", deploymentId);
        });
      }
    }
    for (int i = 10; i < 20; i++) {
      vertx.deployVerticle(new DemoVerticle(i), v -> {
        log.info("deploy result is {}", v.result());
        deploymentIdList.add(v.result());
        integer.incrementAndGet();
      });
    }

    while (integer.get() < 15) {
      Thread.sleep(100);
    }

    for (int i = 0; i < deploymentIdList.size(); i++) {
      if (i % 2 == 0) {
        String deploymentId = deploymentIdList.get(i);
        vertx.undeploy(deploymentId, v -> {
          log.info("undeploy verticle {}", deploymentId);
        });
      }
    }


  }
}
