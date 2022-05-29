package com.codecafe.quarkus.microservices.book.resource;

import javax.ws.rs.core.MediaType;

import io.quarkus.test.junit.QuarkusTest;

import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class BookResourceTest {

  @Test
  void shouldGetAllBooks() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
    .when()
      .get("/api/books")
    .then()
      .statusCode(200)
      .body("size()", is(2));
  }

  @Test
  void shouldCountAllBooks() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
    .when()
      .get("/api/books/count")
    .then()
      .statusCode(200)
      .body(is("2"));
  }

  @Test
  void shouldGetABook() {
    given()
      .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
    .when()
      .get("/api/books/1")
    .then()
      .statusCode(200)
      .body("title", is("Dark Matter"))
      .body("author", is("Blake Crouch"))
      .body("genre", is("Sci-Fi"));
  }

}