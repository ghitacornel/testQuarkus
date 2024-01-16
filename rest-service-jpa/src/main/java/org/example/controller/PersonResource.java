package org.example.controller;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.example.model.PersonRequest;
import org.example.model.PersonResponse;
import org.example.service.PersonService;

import java.util.List;

@Path("persons")
@RequiredArgsConstructor
public class PersonResource {

    private final PersonService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<PersonResponse> findAll() {
        return service.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public PersonResponse findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public PersonResponse save(@Valid PersonRequest person) {
        return service.save(person);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") Long id) {
        service.deleteById(id);
    }

}