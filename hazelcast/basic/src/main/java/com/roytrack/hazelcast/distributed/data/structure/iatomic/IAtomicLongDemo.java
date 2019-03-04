package com.roytrack.hazelcast.distributed.data.structure.iatomic;

import java.util.concurrent.atomic.AtomicLong;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.IFunction;

public class IAtomicLongDemo {
  public static void main(String[] args) {
    simpleUse();
    execFunction();
  }

  private static void simpleUse() {
    HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
    IAtomicLong counter = hazelcastInstance.getAtomicLong("counter");
    long start = System.currentTimeMillis();
    for (int i = 0; i < 1000_000; i++) {
      if (i % 50000 == 0) {
        System.out.println("At: " + i);
      }
      counter.incrementAndGet();
    }
    System.out.printf("Count is %s\n", counter.get());
    System.out.println("IAtomicLong cost " + (System.currentTimeMillis() - start));

    AtomicLong jdkAtomicLong = new AtomicLong();
    start = System.currentTimeMillis();
    for (int i = 0; i < 1000_000; i++) {
      jdkAtomicLong.incrementAndGet();
    }
    System.out.println("jdk AtomicLong cost " + (System.currentTimeMillis() - start));
    System.exit(0);
  }

  private static void execFunction() {
    HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
    IAtomicLong atomicLong = hazelcastInstance.getAtomicLong("counter");

    atomicLong.set(1);
    long result = atomicLong.apply(new Add2Function());
    System.out.println("apply.result: " + result);
    System.out.println("apply.value: " + atomicLong.get());
    atomicLong.set(1);
    atomicLong.alter(new Add2Function());
    System.out.println("alter.value: " + atomicLong.get());
    atomicLong.set(1);
    result = atomicLong.alterAndGet(new Add2Function());
    System.out.println("alterAndGet.result: " + result);
    System.out.println("alterAndGet.value: " + atomicLong.get());
    atomicLong.set(1);
    result = atomicLong.getAndAlter(new Add2Function());
    System.out.println("getAndAlter.result: " + result);
    System.out.println("getAndAlter.value: " + atomicLong.get());

  }

  private static class Add2Function implements IFunction<Long, Long> {
    @Override
    public Long apply(Long input) {
      return input + 2;
    }
  }
}
