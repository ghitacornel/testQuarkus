package org.example.config;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import io.quarkiverse.rabbitmqclient.RabbitMQClient;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class JmsConfig {

    @Inject
    RabbitMQClient rabbitMQClient;

    @Produces
    public Channel setupQueues() {
        Channel channel;
        try {
            // create a connection
            Connection connection = rabbitMQClient.connect();
            // create a channel
            channel = connection.createChannel();
            // declare exchanges and queues
            channel.exchangeDeclare("test", BuiltinExchangeType.TOPIC, true);
            channel.queueDeclare("sample.queue", true, false, false, null);
            channel.queueBind("sample.queue", "test", "#");
            return channel;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
