package org.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class DummyResourceTest {

    @Test
    void testComponents() {

        given()
                .when().get("dummies/singleton")
                .then()
                .statusCode(200)
                .body(is("singleton"));

        given()
                .when().get("dummies/applicationScope")
                .then()
                .statusCode(200)
                .body(is("applicationScoped"));

        given()
                .when().get("dummies/badApplicationScope")
                .then()
                .statusCode(200)
                .body(is("badApplicationScoped"));

    }

}