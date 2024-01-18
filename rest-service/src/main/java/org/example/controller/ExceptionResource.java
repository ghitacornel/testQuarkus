package org.example.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @PATCH
    public Person saveWithValidationException(@Valid Person person) {
        return service.saveWithValidationException(person);
    }

    @POST
    @Path("{id}/{name}")
    public void saveWithValidationOnParameter(@PathParam("id") @Valid @NotNull Integer id, @PathParam("name") @Valid @NotBlank String name) {
        service.saveWithValidationOnParameter(id, name);
    }

}