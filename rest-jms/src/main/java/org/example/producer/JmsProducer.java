package org.example.producer;

import com.rabbitmq.client.Channel;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Singleton
@Slf4j
public class JmsProducer {

    @Inject
    Channel channel;

    public void sendSimpleTextMessageToQueue() {
        String message = "quote-request-message " + LocalDateTime.now();
        log.info("sending message '" + message + "' to 'prices' queue");
        try {
            channel.basicPublish("test", "#", null, message.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
