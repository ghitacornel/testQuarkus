package org.example.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
public class BusinessExceptionHandler implements ExceptionMapper<BusinessException> {
    @Override
    public Response toResponse(BusinessException exception) {
        log.error("business exception", exception);
        return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
    }
}