package com.roytrack.hazelcast.distributed.data.structure.topic;

import com.hazelcast.config.Config;
import com.hazelcast.config.TopicConfig;
import com.hazelcast.core.*;

import java.util.Date;
import java.util.HashMap;

public class TopicDemo {
  public static void main(String[] args) {

    Config config = new Config();
    TopicConfig topicConfig = new TopicConfig();
    topicConfig.setName("topic");
    //设置全局有序
    topicConfig.setGlobalOrderingEnabled(true);
    //设置进行信息统计
    topicConfig.setStatisticsEnabled(true);
    HashMap configMap = new HashMap();
    configMap.put("topic", topicConfig);
    config.setTopicConfigs(configMap);
    HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
    ITopic<Date> topic = instance.getTopic("topic");
    topic.addMessageListener(new MessageListenerImpl());
    int count = 0;
    while (true) {
      Date now = new Date();
      long pubCount = topic.getLocalTopicStats().getPublishOperationCount();
      long recvCount = topic.getLocalTopicStats().getReceiveOperationCount();
      System.out.println("Published :" + now + "pub count is " + pubCount + ",recv count is " + recvCount);
      topic.publish(now);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      if (count++ > 100) {
        break;
      }
    }
    instance.shutdown();
  }

  private static class MessageListenerImpl implements MessageListener<Date> {
    @Override
    public void onMessage(Message<Date> message) {
      System.out.println("Received: " + message.getMessageObject());
    }
  }
}
