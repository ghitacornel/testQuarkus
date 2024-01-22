package org.example.producer;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.example.config.JmsConfig;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Singleton
@Slf4j
public class JmsProducer {

    @Inject
    JmsConfig jmsConfig;

    public void sendSimpleTextMessageToQueue() {
        String message = "quote-request-message " + LocalDateTime.now();
        log.info("sending message '" + message + "' to 'prices' queue");
        try {
            jmsConfig.channel.basicPublish("test", "#", null, message.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
