package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.media.SchemaProperty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "a person create request")
public class PersonCreateRequest {

    @SchemaProperty(name = "name", description = " the name of the person to create", example = "John")
    private String name;

}
