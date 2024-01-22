package org.example.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.example.producer.JmsProducer;

import java.time.LocalDateTime;

@Path("jms")
public class JmsController {

    @Inject
    JmsProducer producer;

    @GET
    @Path("trigger")
    @Produces(MediaType.TEXT_PLAIN)
    public String triggerJMS() {
        producer.sendSimpleTextMessageToQueue();
        return "JMS triggered. Check logs " + LocalDateTime.now();
    }

}
