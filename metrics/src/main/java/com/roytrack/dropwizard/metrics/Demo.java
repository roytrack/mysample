package com.roytrack.dropwizard.metrics;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo {

  protected final MetricRegistry metrics = new MetricRegistry();
  protected final ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(100);
  private final Timer logic = metrics.timer("logic");
  protected ConsoleReporter reporter;

  @Before
  public void init() {
    reporter = ConsoleReporter.forRegistry(metrics)
            .convertRatesTo(TimeUnit.SECONDS)
            .convertDurationsTo(TimeUnit.MILLISECONDS)
            .build();
    reporter.start(1, TimeUnit.SECONDS);
  }

  @Test
  public void doMetrics() throws InterruptedException {
    List<Thread> threads = new ArrayList<>(100);
    for (int i = 0; i < 100; i++) {
      threads.add(getThread(10000));
    }
    Collections.shuffle(threads);
    threads.forEach(t -> executor.submit(t));
    while (executor.getActiveCount() > 0) {
      executor.awaitTermination(2, TimeUnit.SECONDS);
    }

    try {
      Thread.sleep(2 * 1000);
    } catch (InterruptedException e) {
    }

  }

  private Thread getThread(int count) {
    return new Thread(() -> {
      int times = 100;
      while (times-- > 0) {
        final Timer.Context context = logic.time();
        try {
          ArrayList list = new ArrayList(count);
          list.add(new BigDecimal(times));
        } catch (Throwable t) {
          t.printStackTrace();
        } finally {
          context.stop();
        }
      }
    });
  }
}
