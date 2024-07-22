package com.pabloquiroga.essentials.users;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.containsString;

@QuarkusTest
@TestHTTPEndpoint(UsersResourcesBasics.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UsersResourcesBasicsTest {

    @Test
    @Order(2)
    void createUser_returns_BooleanOfSuccess() {
        given()
                .body(
                        User.of("pablo", "quiroga", "04/03/1978")
                )
                .contentType(ContentType.JSON)
                .when()
                .post("create")
                .then()
                .statusCode(200)
                .body(is("true"));
    }

    @Test
    @Order(3)
    void GetUserDefault_returns_User(){
        given()
                .when()
                .get("/default")
                .then()
                .statusCode(200)
                .body(containsStringIgnoringCase("pablo"));
    }

    @Test
    @Order(1)
    void getUserDefault_returns_NotFound(){
        given()
                .when()
                .get("/default")
                .then()
                .statusCode(404)
                .body(containsString("No hay datos"));
    }

    @Test
    void getUserById_withParamNotValid_returns_NotFound(){
        given()
                .queryParam("id", 1)
                .when()
                .get("/id")
                .then()
                .statusCode(404)
                .body(containsString("No hay datos"));
    }

    @Test
    void getClassMessage_returns_String(){
        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .body(containsString("Hello"));
    }
}