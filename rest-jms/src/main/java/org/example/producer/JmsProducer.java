package org.example.producer;

import jakarta.inject.Singleton;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.time.LocalDateTime;

@Singleton
public class JmsProducer {

    @Channel("quote-requests")
    Emitter<String> quoteRequestEmitter;

    public void sendSimpleTextMessageToQueue() {
        quoteRequestEmitter.send("quote-request-message " + LocalDateTime.now());
    }

}
