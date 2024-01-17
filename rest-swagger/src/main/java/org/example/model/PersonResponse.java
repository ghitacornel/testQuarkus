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
@Schema(description = "a person details")
public class PersonResponse {

    @SchemaProperty(name = "id", description = "id of the created person", example = "1")
    private Long id;

    @SchemaProperty(name = "name", description = "name of the created person", example = "John")
    private String name;

}
