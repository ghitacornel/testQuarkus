package org.example.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import lombok.RequiredArgsConstructor;
import org.example.model.Person;
import org.example.service.PersonService;

@Path("controller-validations")
@RequiredArgsConstructor
public class PersonResource {

    private final PersonService service;

    @GET
    @Path("{id}")
    public Person findById(@PathParam("id") @Positive Integer id) {
        return service.findById(id);
    }

    @POST
    public Person save(@Valid Person person) {
        return service.save(person);
    }

}