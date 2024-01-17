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
                .body(is("value1"));

        given()
                .when().get("yaml/propertyB")
                .then()
                .statusCode(200)
                .body(is("value2"));

        given()
                .when().get("yaml/propertyWithDefault")
                .then()
                .statusCode(200)
                .body(is("default value"));

    }

}