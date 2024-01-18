package org.example.controller;

import jakarta.validation.Valid;
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
    @Path("{id}")
    public Person findById(@PathParam("id") Integer id) {
        return service.findById(id);
    }
    
    @POST
    public Person save(@Valid Person person) {
        return service.save(person);
    }

}