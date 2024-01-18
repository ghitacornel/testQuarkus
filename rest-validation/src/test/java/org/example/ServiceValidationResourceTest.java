package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import lombok.SneakyThrows;
import org.example.model.RequestDto;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class ServiceValidationResourceTest {

    public static final String PATH = "service-validations";
    @Inject
    ObjectMapper objectMapper;

    @Test
    void findById() {

        given()
                .when().get(PATH + "/1")
                .then()
                .statusCode(200)
                .body(is("{\"id\":1,\"name\":\"John\"}"));

        given()
                .when().get(PATH + "/-1")
                .then()
                .statusCode(400)
                .body(is("{\"title\":\"Constraint Violation\",\"status\":400,\"violations\":[{\"field\":\"findById.arg0\",\"message\":\"must be greater than 0\"}]}"));

    }

    @Test
    @SneakyThrows
    void save() {

        given()
                .contentType(ContentType.JSON)
                .body(RequestDto.builder()
                        .id(1)
                        .name("John")
                        .build())
                .when().post(PATH)
                .then()
                .statusCode(200)
                .body(is(objectMapper.writeValueAsString(RequestDto.builder()
                        .id(1)
                        .name("John")
                        .build())));

        given()
                .contentType(ContentType.JSON)
                .body(RequestDto.builder()
                        .id(null)
                        .name("John")
                        .build())
                .when().post(PATH)
                .then()
                .statusCode(400)
                .body(is("{\"title\":\"Constraint Violation\",\"status\":400,\"violations\":[{\"field\":\"save.arg0.id\",\"message\":\"must not be null\"}]}"));

        given()
                .contentType(ContentType.JSON)
                .body(RequestDto.builder()
                        .id(1)
                        .name("  ")
                        .build())
                .when().post(PATH)
                .then()
                .statusCode(400)
                .body(is("{\"title\":\"Constraint Violation\",\"status\":400,\"violations\":[{\"field\":\"save.arg0.name\",\"message\":\"must not be blank\"}]}"));

        given()
                .contentType(ContentType.JSON)
                .body(RequestDto.builder()
                        .id(null)
                        .name("")
                        .build())
                .when().post(PATH)
                .then()
                .statusCode(400)
                .and()
                .body(containsString("save.arg0.id"))
                .and()
                .body(containsString("must not be null"))
                .and()
                .body(containsString("save.arg0.name"))
                .and()
                .body(containsString("must not be blank"))
        ;


    }

}