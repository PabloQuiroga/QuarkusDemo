package com.pabloquiroga.essentials.greetings;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(GreetingResource.class)
public class GreetingResourceTest {

    /**
     Patron =>

     Given
      - dado un escenario
     When
      - cuando ejecutes una accion dada
     Then
      - esperas un resultado
     */

    @Test
    void test_greetingsWithoutQuery() {
        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .body(is("Hello from Quarkus"));
    }

    @Test
    void test_Resource_GreetingsWithoutName_returns_errorParam(){
        given()
                .queryParam("name", "")
                .when()
                .get()
                .then()
                .statusCode(200)
                .body(is("No se ha compartido un parametro para nombre"));
    }

    @Test
    void test_Resource_GreetingsWithName_returnGreetings(){
        given()
                .queryParam("name", "Pablo")
                .when()
                .get()
                .then()
                .statusCode(200)
                .body(is("Hola Pablo"));
    }
}