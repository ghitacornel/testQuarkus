package org.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class PropertiesResourceTest {

    @Test
    void testProperties() {

        given()
                .when().get("properties/property1")
                .then()
                .statusCode(200)
                .body(is("value1"));

        given()
                .when().get("properties/property2")
                .then()
                .statusCode(200)
                .body(is("value2"));

    }

}