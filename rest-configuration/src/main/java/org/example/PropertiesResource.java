package org.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;


@Path("properties")
@RequiredArgsConstructor
public class PropertiesResource {

    @ConfigProperty(name = "property1")
    String property1;

    @ConfigProperty(name = "property2")
    String property2;

    @GET
    @Path("property1")
    @Produces(MediaType.TEXT_PLAIN)
    public String property1() {
        return property1;
    }

    @GET
    @Path("property2")
    @Produces(MediaType.TEXT_PLAIN)
    public String property2() {
        return property2;
    }
}