package org.example.controller;

import jakarta.ws.rs.*;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.tags.Tags;
import org.example.model.PersonCreateRequest;
import org.example.model.PersonResponse;

@Tags(value = {
        @Tag(name = "tag1", description = "tag1 description"),
        @Tag(name = "tag2", description = "tag2 description")
})
@Path("persons")
@RequiredArgsConstructor
public class PersonResource {

    @Tags(value = {
            @Tag(name = "tag3", description = "tag3 description")
    })
    @Operation(summary = "summary of GET find all", description = "description of GET find all")
    @GET
    @Path("{id}")
    public PersonResponse findById(@Parameter(name = "id", description = "id of the person", required = true) @PathParam("id") Long id) {
        return new PersonResponse();
    }

    @Operation(summary = "summary of POST create person", description = "description of POST create person")
    @APIResponses(value = {
            @APIResponse(responseCode = "400", description = "invalid person create request"),
            @APIResponse(responseCode = "200", description = "created person data", content = @Content(schema = @Schema(implementation = PersonResponse.class)))
    })
    @POST
    public PersonResponse save(@RequestBody(content = @Content(schema = @Schema(implementation = PersonCreateRequest.class))) PersonCreateRequest request) {
        return new PersonResponse();
    }

    @Operation(summary = "DELETE by id")
    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") Long id) {
    }

}