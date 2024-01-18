package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import lombok.SneakyThrows;
import org.example.model.Person;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class PersonResourceTest {

    @Inject
    ObjectMapper objectMapper;

    @Test
    void findById() {

        given()
                .when().get("persons/1")
                .then()
                .statusCode(200)
                .body(is("{\"id\":1,\"name\":\"John\"}"));

    }

    @Test
    @SneakyThrows
    void save() {

        given()
                .contentType(ContentType.JSON)
                .body(Person.builder()
                        .id(1)
                        .name("John")
                        .build())
                .when().post("persons")
                .then()
                .statusCode(200)
                .body(is(objectMapper.writeValueAsString(Person.builder()
                        .id(1)
                        .name("John")
                        .build())));

        given()
                .contentType(ContentType.JSON)
                .body(Person.builder()
                        .id(null)
                        .name("John")
                        .build())
                .when().post("persons")
                .then()
                .statusCode(400)
                .body(is("{\"title\":\"Constraint Violation\",\"status\":400,\"violations\":[{\"field\":\"save.arg0.id\",\"message\":\"must not be null\"}]}"));

        given()
                .contentType(ContentType.JSON)
                .body(Person.builder()
                        .id(1)
                        .name("  ")
                        .build())
                .when().post("persons")
                .then()
                .statusCode(400)
                .body(is("{\"title\":\"Constraint Violation\",\"status\":400,\"violations\":[{\"field\":\"save.arg0.name\",\"message\":\"must not be blank\"}]}"));

        given()
                .contentType(ContentType.JSON)
                .body(Person.builder()
                        .id(null)
                        .name("")
                        .build())
                .when().post("persons")
                .then()
                .statusCode(400)
                .and()
                .body(is("{\"title\":\"Constraint Violation\",\"status\":400,\"violations\":[{\"field\":\"save.arg0.id\",\"message\":\"must not be null\"},{\"field\":\"save.arg0.name\",\"message\":\"must not be blank\"}]}"));


    }

}