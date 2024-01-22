package org.example.consumer;

import com.rabbitmq.client.*;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.example.config.JmsConfig;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Singleton
@Slf4j
public class JmsConsumer {

    @Inject
    JmsConfig jmsConfig;

    @PostConstruct
    private void setupReceiving() throws IOException {

        // register a consumer for messages
        jmsConfig.channel.basicConsume("sample.queue", true, new DefaultConsumer(jmsConfig.channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
                // just print the received message.
                log.info("Received: " + new String(body, StandardCharsets.UTF_8));
            }
        });

    }

}
