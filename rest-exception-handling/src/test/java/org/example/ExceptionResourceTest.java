package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import lombok.SneakyThrows;
import org.example.model.RequestDto;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ExceptionResourceTest {

    private static final String PATH = "test-exceptions";

    @Inject
    ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    void process() {

        // no exception here
        given()
                .contentType(ContentType.JSON)
                .body(RequestDto.builder()
                        .id(1)
                        .name("John")
                        .build())
                .when().put(PATH)
                .then()
                .statusCode(200)
                .body(is(objectMapper.writeValueAsString(RequestDto.builder()
                        .id(1)
                        .name("John")
                        .build())));

        // exception here
        given()
                .contentType(ContentType.JSON)
                .body(RequestDto.builder()
                        .id(-1)
                        .name("one")
                        .build())
                .when().put(PATH)
                .then()
                .statusCode(406)
                .body(is("negative ID"));

    }

}