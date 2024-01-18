package org.example.controller;

import jakarta.ws.rs.*;
import lombok.RequiredArgsConstructor;
import org.example.model.Person;
import org.example.service.PersonService;

@Path("exceptions")
@RequiredArgsConstructor
public class ExceptionResource {

    private final PersonService service;

    @PUT
    public Person saveWithException(Person person) {
        return service.saveWithException(person);
    }

}