package org.example.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import lombok.RequiredArgsConstructor;
import org.example.model.RequestDto;
import org.example.service.BusinessService;

@Path("controller-validations")
@RequiredArgsConstructor
public class ControllerValidationResource {

    private final BusinessService service;

    @GET
    @Path("{id}")
    public RequestDto findById(@PathParam("id") @Positive Integer id) {
        return service.findById(id);
    }

    @POST
    public RequestDto save(@Valid RequestDto person) {
        return service.save(person);
    }

}