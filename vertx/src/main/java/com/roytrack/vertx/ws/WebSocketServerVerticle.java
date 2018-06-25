package com.roytrack.vertx.ws;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpServerOptions;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by roytrack at 2018/6/22 上午11:56
 */

@Slf4j
public class WebSocketServerVerticle extends AbstractVerticle {

    @Getter
    @Setter
    private String host;
    @Getter
    @Setter
    private int port;


    public static void main(String[] args) {
        System.setProperty("vertx.logger-delegate-factory-class-name", "io.vertx.core.logging.SLF4JLogDelegateFactory");
        String theHost = "localhost";
        int thePort = 10617;
        VertxOptions options=new VertxOptions().setBlockedThreadCheckInterval(10_000L).setWarningExceptionTime(9_000L)
                .setMaxEventLoopExecuteTime(30L * 1000 * 1000000);
        Vertx vertx = Vertx.vertx(options);

        WebSocketServerVerticle serverVerticle = new WebSocketServerVerticle();
        serverVerticle.setHost(theHost);
        serverVerticle.setPort(thePort);
        vertx.deployVerticle(serverVerticle, v -> {
            if (v.succeeded()) {
                WebSocketClientVerticle clientVerticle = new WebSocketClientVerticle();
                clientVerticle.setHost(theHost);
                clientVerticle.setPort(thePort);
                vertx.deployVerticle(clientVerticle);
            }
        });
        vertx.exceptionHandler(t -> {
            log.error("vertx error :", t);
        });

    }

    @Override
    public void start() {
        try {
            HttpServerOptions opts = new HttpServerOptions().setTcpFastOpen(true)
                    .setTcpKeepAlive(true)
                    .setHost(host)
                    .setPort(port)
                    //支持可压缩
                    //.setCompressionSupported(true)
                    ;

            char[] c100 = new char[100];
            Arrays.fill(c100, (char) 64);
            String fullStr = "full but I still put in .";
            AtomicInteger count = new AtomicInteger();
            vertx.createHttpServer(opts)
                    .websocketHandler(conn -> {
                        conn.setWriteQueueMaxSize(1 * 1024);
                        conn.textMessageHandler(h -> {
                            log.info("receive text message :{}", h);
                        });
                        vertx.setPeriodic(10, lh -> {
                            if (!conn.writeQueueFull()) {
                                count.incrementAndGet();
                                conn.writeTextMessage(String.valueOf(c100)+"###"+count.get());
                            } else {

                                count.incrementAndGet();
                                conn.writeTextMessage(fullStr+"$$$"+count.get());
                                if (count.get() % 100 == 0) {
                                    log.info("this is full,try add more data，count is {}", count.get());
                                }
                            }
                            if (count.get() % 100 == 0) {
                                log.info("send 100 message");
                            }

                        });
                    })
                    .listen();
        } catch (Throwable e) {
            log.error("server error:", e);
        }

    }


}
