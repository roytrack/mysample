package com.roytrack.disruptor.startup;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by roytrack on 2016-08-23.
 */
public class LongEventMainWithJava8 {

  public static volatile int a = 0;
  public static AtomicInteger b = new AtomicInteger(0);

  public static void main(String[] args) throws InterruptedException {
    Thread.sleep(40000);


    Executor executor = Executors.newCachedThreadPool();

    int bufferSize = 1024;

    Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new, bufferSize, DaemonThreadFactory.INSTANCE);

    //Disruptor<LongEvent> disruptor=new Disruptor<>(LongEvent::new,bufferSize, executor);

    disruptor.handleEventsWith((event, sequence, endOfBatch) -> System.out.println("event " + event));

    disruptor.start();

    RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

    ByteBuffer bb = ByteBuffer.allocate(8);
    long start = System.nanoTime();
    System.out.println(start);
    for (long l = 0l; l < 100000l; l++) {
      bb.putLong(0, l);
      ringBuffer.publishEvent((event, sequence, arg0) -> event.setValue(arg0.getLong(0)), bb);

    }
    System.out.println("===============");
    System.out.println(System.nanoTime() - start);
    System.out.println("===============");
    System.out.println("the value of a is " + a);
    System.out.println("the value of b is " + b);
    disruptor.shutdown();


  }
}
