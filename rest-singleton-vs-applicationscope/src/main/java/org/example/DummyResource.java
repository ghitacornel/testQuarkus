package org.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("dummies")
public class DummyResource {

    @Inject
    DummySingleton dummySingleton;

    @Inject
    DummyApplicationScoped dummyApplicationScoped;

    @Inject
    DummyBadApplicationScoped dummyBadApplicationScoped;

    @GET
    @Path("singleton")
    @Produces(MediaType.TEXT_PLAIN)
    public String singleton() {
        return dummySingleton.invoke();
    }

    @GET
    @Path("applicationScope")
    @Produces(MediaType.TEXT_PLAIN)
    public String applicationScope() {
        return dummyApplicationScoped.invoke();
    }

    @GET
    @Path("badApplicationScope")
    @Produces(MediaType.TEXT_PLAIN)
    public String badApplicationScope() {
        return dummyBadApplicationScoped.invoke();
    }
}
