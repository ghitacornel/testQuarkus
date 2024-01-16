package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import lombok.SneakyThrows;
import org.example.model.Person;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Inject
    ObjectMapper objectMapper;

    @Test
    void hello() {
        given()
                .when().get("api/person")
                .then()
                .statusCode(200)
                .body(is("Hello from RESTEasy Reactive"));
    }

    @Test
    void deleteById() {
        given()
                .when().pathParam("id", 1).delete("api/person/{id}")
                .then()
                .statusCode(204)
                .body(Matchers.blankString());
    }

    @Test
    @SneakyThrows
    void save() {
        given()
                .contentType(ContentType.JSON)
                .body(Person.builder()
                        .id(1)
                        .name("one")
                        .build())
                .when().post("api/person")
                .then()
                .statusCode(200)
                .body(is(objectMapper.writeValueAsString(Person.builder()
                        .id(2)
                        .name("one one")
                        .build())));
    }

    @Test
    @SneakyThrows
    void saveWithException() {

        // no exception here
        given()
                .contentType(ContentType.JSON)
                .body(Person.builder()
                        .id(1)
                        .name("one")
                        .build())
                .when().put("api/exception")
                .then()
                .statusCode(200)
                .body(is(objectMapper.writeValueAsString(Person.builder()
                        .id(1)
                        .name("one")
                        .build())));

        // exception here
        given()
                .contentType(ContentType.JSON)
                .body(Person.builder()
                        .id(null)
                        .name("one")
                        .build())
                .when().put("api/exception")
                .then()
                .statusCode(400)
                .body(is("dummy exception"));

    }

    @Test
    @SneakyThrows
    void saveWithValidationException() {

        // no exception here
        given()
                .contentType(ContentType.JSON)
                .body(Person.builder()
                        .id(1)
                        .name("one")
                        .build())
                .when().patch("api/exception")
                .then()
                .statusCode(200)
                .body(is(objectMapper.writeValueAsString(Person.builder()
                        .id(1)
                        .name("one")
                        .build())));

        // exception here
        given()
                .contentType(ContentType.JSON)
                .body(Person.builder()
                        .id(-1)
                        .name("")
                        .build())
                .when().patch("api/exception")
                .then()
                .statusCode(400)
                .body(is("{\"title\":\"Constraint Violation\",\"status\":400,\"violations\":[{\"field\":\"saveWithValidationException.arg0.name\",\"message\":\"must not be blank\"}]}"));

    }

}