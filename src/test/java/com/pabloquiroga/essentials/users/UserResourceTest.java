package com.pabloquiroga.essentials.users;

import io.quarkus.test.InjectMock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@QuarkusTest
@TestHTTPEndpoint(UserResource.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserResourceTest {

    @InjectMock
    private UserRepository repository;

    @Test
    void getAllUsers_returns_listWithData(){
        //TODO
    }

    @Test
    void getFirst() {
        //TODO
    }

    @Test
    void getById() {
        //TODO
    }

    @Test
    void saveUser() {
        //TODO
    }

    @Test
    void deleteUser() {
        //TODO
    }

    @Test
    void updateUser() {
        //TODO
    }
}
