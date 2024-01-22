package org.example.consumer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Singleton
@Slf4j
public class JmsConsumer {

    @Inject
    Channel channel;

    @PostConstruct
    private void setupReceiving() throws IOException {

        // register a consumer for messages
        channel.basicConsume("sample.queue", true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
                // just print the received message.
                log.info("Received: " + new String(body, StandardCharsets.UTF_8));
            }
        });

    }

}
