package org.example;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class YamlResourceTest {

    @Test
    void testProperties() {

        given()
                .when().get("yaml/propertyA")
                .then()
                .statusCode(200)
                .body(is("valueA"));

        given()
                .when().get("yaml/propertyB")
                .then()
                .statusCode(200)
                .body(is("valueY"));

        given()
                .when().get("yaml/propertyWithDefault")
                .then()
                .statusCode(200)
                .body(is("default value"));

    }

}