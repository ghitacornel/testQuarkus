package org.example.controller;

import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import org.example.model.RequestDto;
import org.example.service.BusinessService;

@Path("test-exceptions")
@RequiredArgsConstructor
public class ExceptionResource {

    private final BusinessService service;

    @PUT
    public RequestDto process(RequestDto requestDto) {
        return service.process(requestDto);
    }

}