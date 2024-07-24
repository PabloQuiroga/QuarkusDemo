package com.pabloquiroga.essentials.books;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectSpy;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.verify;

@QuarkusTest
@TestHTTPEndpoint(BookResource.class)
class BookResourceTest {

    private static final Logger log = LoggerFactory.getLogger(BookResourceTest.class);
    @InjectSpy
    BooksService service;

    Book mockBook;

    @BeforeEach
    void setUp() {
        mockBook = Book.builder()
                .title("El problema de los tres cuerpos")
                .author("Pablo Quiroga")
                .editorial("ArgentoSA")
                .anio_lanzamiento("2024")
                .build();
    }

    @Test
    void createBook() {
        Response post = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(mockBook)
                .when().post("/create");
        post.then()
                .statusCode(200)
                .body("editorial", containsString("Argento"));

        long id = ((Integer)post.body().path("id")).longValue();
        service.deleteById(id);
    }

    @Test
    void getAllBooks_returns_listOfBooks() {
        given()
                .when()
                .get("/list")
                .then()
                .statusCode(200);
        verify(service).getAll();
        log.info(service.getAll().toString());
    }
}