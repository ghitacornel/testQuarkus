package org.example;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.example.model.PersonCreateRequest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@Transactional
class PersonResourceBadDataTest {


    @Test
    @SneakyThrows
    void testBadData() {

        // create with bad data
        {
            given()
                    .contentType(ContentType.JSON)
                    .body(PersonCreateRequest.builder()
                            .name("")
                            .build())
                    .when().post("persons")
                    .then()
                    .statusCode(400)
                    .body(is("{\"title\":\"Constraint Violation\",\"status\":400,\"violations\":[{\"field\":\"save.arg0.name\",\"message\":\"must not be blank\"}]}"));
        }

    }

}