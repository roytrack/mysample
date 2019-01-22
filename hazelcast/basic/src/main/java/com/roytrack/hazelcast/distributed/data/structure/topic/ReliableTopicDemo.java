package com.roytrack.hazelcast.distributed.data.structure.topic;

import java.util.HashMap;
import java.util.Random;

import com.hazelcast.config.Config;
import com.hazelcast.config.ReliableTopicConfig;
import com.hazelcast.config.RingbufferConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;
import com.hazelcast.topic.TopicOverloadPolicy;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class ReliableTopicDemo {
  public static void main(String[] args) {

    Config config = new Config();

    RingbufferConfig ringbufferConfig = new RingbufferConfig();
    ringbufferConfig.setCapacity(100);
    ringbufferConfig.setName("roytopic");
    ringbufferConfig.setTimeToLiveSeconds(10);
    HashMap ringBufferConfigMap = new HashMap();
    ringBufferConfigMap.put("roytopic", ringbufferConfig);
    config.setRingbufferConfigs(ringBufferConfigMap);

    ReliableTopicConfig topicConfig = new ReliableTopicConfig();
    topicConfig.setName("roytopic");
    //设置读取batch数量
    topicConfig.setReadBatchSize(100);
    //设置进行信息统计
    topicConfig.setStatisticsEnabled(true);
    //设置topic加消息过快的策略为block
    topicConfig.setTopicOverloadPolicy(TopicOverloadPolicy.BLOCK);
    HashMap configMap = new HashMap();
    configMap.put("roytopic", topicConfig);
    config.setReliableTopicConfigs(configMap);


    HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
    Random random = new Random();
    ITopic<Long> topic = instance.getReliableTopic("roytopic");
    topic.addMessageListener(new MessageListenerImpl());
    long messageId = 0;
    while (true) {
      topic.publish(messageId);
      messageId++;
      System.out.println("Written: " + messageId);
      sleepMillis(random.nextInt(100));
    }
  }

  public static boolean sleepMillis(int millis) {
    try {
      MILLISECONDS.sleep(millis);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return false;
    }
    return true;
  }

  private static class MessageListenerImpl implements MessageListener<Long> {

    @Override
    public void onMessage(Message<Long> message) {
      try {
        MILLISECONDS.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Received: " + message.getMessageObject());
    }
  }
}
