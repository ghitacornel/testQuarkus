package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.example.model.Person;
import org.example.service.PersonService;

@Path("persons")
@RequiredArgsConstructor
public class PersonResource {

    private final PersonService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("bad luck");
        }
    }

    @POST
    public Person save(Person person) {
        return service.save(person);
    }

}