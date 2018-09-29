package com.roytrack.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by roytrack on 2017-03-29.
 */
public class WorkQueueDemo {
  private static String mqUrl = "10.87.156.55";
  private static int mqPort = 5672;
  private static String QUEUE_NAME = "worker";

  public static void main(String[] args) throws IOException {
    WorkQueueDemo d = new WorkQueueDemo();
    for (int i = 0; i < 100; i++) {
      String[] msg;
      if (i == 0) {
        msg = new String[1];
        msg[0] = "hello mq";
      } else {
        msg = new String[i];
        msg[0] = "hello mq";
      }
      for (int j = 1; j < msg.length; j++) {
        msg[j] = ".";
      }
      d.send(msg);
    }

    System.out.println("enqueue finish");
    d.recv();
  }

  public static String getMessage(String[] strings) {
    if (strings.length < 1) {
      return "hello rabbit mq";
    }
    return joinStrings(strings, " ");

  }

  public static String joinStrings(String[] strings, String delimiter) {
    int length = strings.length;
    if (length == 0) {
      return "";
    }
    StringBuilder words = new StringBuilder(strings[0]);
    for (int i = 1; i < length; i++) {
      words.append(delimiter).append(strings[i]);
    }
    return words.toString();
  }

  private static void doWork(String task) throws InterruptedException {
    for (char ch : task.toCharArray()) {
      if (ch == '.') {
        Thread.sleep(1000);
      }
    }
  }

  public Channel getChannel() throws IOException {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost(mqUrl);
    factory.setPort(mqPort);
    factory.setUsername("roytrack");
    factory.setPassword("roytrack");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();
    ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
    return channel;
  }

  public void send(String[] message) throws IOException {
    String msg = getMessage(message);
    Channel channel = getChannel();
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
    System.out.println("[x] Sent '" + msg + "'");
    channel.close();
  }

  public void recv() throws IOException {
    Channel channel = getChannel();
    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    Consumer consumer = new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag,
                                 Envelope envelope,
                                 AMQP.BasicProperties properties,
                                 byte[] body)
              throws IOException {
        String message = new String(body, "UTF-8");
        System.out.println("[x]Received '" + message + "'");
        try {
          doWork(message);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          System.out.println(" [x] Done");
        }
      }

    };
    channel.basicConsume(QUEUE_NAME, true, consumer);
  }

}
