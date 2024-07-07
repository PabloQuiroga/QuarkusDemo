package com.pabloquiroga.essentials;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class GreetingResourceTest {

    @Test
    void testHelloEndpoint() {
        given()
                .when()
                .get("/greetings")
                .then()
                .statusCode(200)
                .body(is("Hello from Quarkus"));
    }

    @Test
    void test_Resource_GreetingsWithoutName_returnGenericGreetings(){
        given()
                .when()
                .get("/greetings/")
                .then()
                .statusCode(200)
                .body(is("Hello from Quarkus"));
    }

    @Test
    void test_Resource_GreetingsWithName_returnGreetings(){
        given()
                .when()
                .get("/greetings/pablo")
                .then()
                .statusCode(200)
                .body(is("Hello pablo"));
    }
}