package org.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;


@Path("yaml")
@RequiredArgsConstructor
public class YamlResource {

    @ConfigProperty(name = "contextOne.propertyA")
    String c1propertyA;

    @ConfigProperty(name = "contextOne.propertyB")
    String c1propertyB;

    @ConfigProperty(name = "contextTwo.propertyA")
    String c2propertyA;

    @ConfigProperty(name = "contextTwo.propertyB")
    String c2propertyB;

    @ConfigProperty(name = "contextOne.propertyWithDefault", defaultValue = "default value")
    String propertyWithDefault;

    @GET
    @Path("propertyA")
    @Produces(MediaType.TEXT_PLAIN)
    public String propertyA() {
        return c1propertyA;
    }

    @GET
    @Path("propertyB")
    @Produces(MediaType.TEXT_PLAIN)
    public String c1propertyB() {
        return c1propertyB;
    }

}