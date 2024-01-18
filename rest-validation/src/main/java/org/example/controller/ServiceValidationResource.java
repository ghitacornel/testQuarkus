package org.example.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import lombok.RequiredArgsConstructor;
import org.example.model.RequestDto;
import org.example.service.ServiceValidationService;

@Path("service-validations")
@RequiredArgsConstructor
public class ServiceValidationResource {

    private final ServiceValidationService service;

    @GET
    @Path("{id}")
    public RequestDto findById(@PathParam("id") Integer id) {
        return service.findById(id);
    }

    @POST
    public RequestDto save(RequestDto person) {
        return service.save(person);
    }

}