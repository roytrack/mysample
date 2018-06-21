package com.roytrack.dailytest.collection;

import java.util.ArrayDeque;

/**
 * Created by roytrack at 2018/6/21 下午4:12
 */

public class ArrayDequeTest {

  public static void main(String[] args) {
    ArrayDeque<Long> deque=new ArrayDeque<>(3);
    deque.push(1L);
    deque.push(2L);
    deque.push(3L);
    deque.push(4L);
    System.out.println(deque);
    deque.push(5L);
    while (deque.size()>2){
      deque.pollLast();
      System.out.println(deque);
      System.out.println("######");
    }

    Long l1=1L;
    if(l1.equals(1L)){
      System.out.println("unbox");
    }
  }

}
