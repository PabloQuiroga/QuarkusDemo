package com.pabloquiroga.essentials.users;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
@TestHTTPEndpoint(UserResource.class)
public class UserResourceTest {
    private final User u1 = new User("juan", "perez", "01/01/2000");
    private final User u2 = new User("Pablo", "perez", "01/01/1996");

    @Test
    void test_GetUserDefault_returns_User(){
        given().when()
                .get("/default")
                .then()
                .statusCode(200)
                .body(containsStringIgnoringCase(u1.name));
    }

    @Test
    void test_createUser_returns_BooleanOfSuccess() {
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
    void test_getUserById_returns_User(){
        given()
                .queryParam("id", 1)
                .when()
                    .get("/id")
                .then()
                    .statusCode(200)
                    .body(containsStringIgnoringCase(u1.name));
    }

    @Test
    void test_getClassMessage_returns_String(){
        given().when().get()
                .then()
                .statusCode(200)
                .body(containsString("Hello"));
    }
}
