package org.example.controller;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import lombok.RequiredArgsConstructor;
import org.example.model.PersonCreateRequest;
import org.example.model.PersonResponse;
import org.example.service.PersonService;

import java.util.List;

@Path("persons")
@RequiredArgsConstructor
public class PersonResource {

    private final PersonService service;

    @GET
    public List<PersonResponse> findAll() {
        return service.findAll();
    }

    @GET
    @Path("{id}")
    public PersonResponse findById(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @POST
    public PersonResponse save(@Valid PersonCreateRequest request) {
        return service.save(request);
    }

    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") Long id) {
        service.deleteById(id);
    }

}