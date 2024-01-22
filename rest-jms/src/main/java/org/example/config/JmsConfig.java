package org.example.config;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import io.quarkiverse.rabbitmqclient.RabbitMQClient;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class JmsConfig {

    @Inject
    RabbitMQClient rabbitMQClient;

    public Channel channel;

    @PostConstruct
    public void onApplicationStart() {
        setupQueues();
    }

    private void setupQueues() {
        try {
            // create a connection
            Connection connection = rabbitMQClient.connect();
            // create a channel
            channel = connection.createChannel();
            // declare exchanges and queues
            channel.exchangeDeclare("test", BuiltinExchangeType.TOPIC, true);
            channel.queueDeclare("sample.queue", true, false, false, null);
            channel.queueBind("sample.queue", "test", "#");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
