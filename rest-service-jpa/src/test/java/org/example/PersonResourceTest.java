package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class PersonResourceTest {

    @Inject
    ObjectMapper objectMapper;

    @Test
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

    }

}