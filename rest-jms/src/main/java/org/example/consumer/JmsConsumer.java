package org.example.consumer;

import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@Singleton
@Slf4j
public class JmsConsumer {

    @Incoming("quote-requests")
    public void process(String message) {
        log.info("received message '{}' from queue 'simple-text-requests-queues'", message);
    }
}
