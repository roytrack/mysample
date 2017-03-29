package com.roytrack.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * a demo use rabbitmq
 * Created by roytrack on 2017-03-29.
 */
public class FirstDemo {

    private static String mqUrl="10.87.156.55";
    private static int mqPort=5672;
    private static String QUEUE_NAME="roytrack";

    public static void main(String[] args) throws IOException {
        FirstDemo d=new FirstDemo();
        for(int i=0;i<1000;i++)
        d.send("hello mq"+i);
        System.out.println("enqueue finish");
        d.recv();
    }

    public Channel getChannel() throws IOException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost(mqUrl);
        factory.setPort(mqPort);
        factory.setUsername("roytrack");
        factory.setPassword("roytrack");
        Connection connection=factory.newConnection();
        Channel channel=connection.createChannel();
        return  channel;
    }

    public void send(String message) throws IOException {
        Channel channel=getChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("[x] Sent '" + message + "'");
        channel.close();
    }

    public void recv() throws IOException {
        Channel channel=getChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body)
                    throws IOException
            {
                String message=new String(body,"UTF-8");
                System.out.println("[x]Received '"+message+"'");
            }

        };
        channel.basicConsume(QUEUE_NAME,true,consumer);
    }


}
