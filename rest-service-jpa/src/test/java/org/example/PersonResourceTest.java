package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.example.model.PersonCreateRequest;
import org.example.model.PersonResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@Transactional
class PersonResourceTest {

    @Inject
    ObjectMapper objectMapper;

    @Test
    @SneakyThrows
    void testCRUD() {

        // find all expect nothing
        given()
                .when().get("persons")
                .then()
                .statusCode(200)
                .body(is("[]"));

        // find by id expect nothing
        given()
                .when().get("persons/1")
                .then()
                .statusCode(204)
                .body(Matchers.blankString());

        // create
        PersonResponse personResponse = given()
                .contentType(ContentType.JSON)
                .body(PersonCreateRequest.builder()
                        .name("one")
                        .build())
                .when().post("persons")
                .then()
                .statusCode(200)
                .extract().as(PersonResponse.class);
        Assertions.assertNotNull(personResponse.getId());
        Assertions.assertEquals("one", personResponse.getName());

        // find by id expect something
        given()
                .when().pathParam("id", personResponse.getId()).get("persons/{id}")
                .then()
                .statusCode(200)
                .body(is(objectMapper.writeValueAsString(personResponse)));

        // find all expect something
        given()
                .when().get("persons")
                .then()
                .statusCode(200)
                .body(is("[" + objectMapper.writeValueAsString(personResponse) + "]"));

        // delete by id
        given()
                .when().pathParam("id", personResponse.getId()).delete("persons/{id}")
                .then()
                .statusCode(204)
                .body(Matchers.blankString());

        // find all expect nothing
        given()
                .when().get("persons")
                .then()
                .statusCode(200)
                .body(is("[]"));

        // find by id expect nothing
        given()
                .when().get("persons/1")
                .then()
                .statusCode(204)
                .body(Matchers.blankString());
    }

}