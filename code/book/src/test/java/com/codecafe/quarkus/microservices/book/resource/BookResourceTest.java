package com.codecafe.quarkus.microservices.book.resource;

import javax.ws.rs.core.MediaType;

import io.quarkus.test.junit.QuarkusTest;

import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

@QuarkusTest
class BookResourceTest {

  @Test
  void shouldCreateABook() {
    given()
      .formParam("title", "Dark Matter")
      .formParam("author", "Blake Crouch")
      .formParam("year", 2016)
      .formParam("genre", "Sci-Fi")
    .when()
      .post("api/books")
    .then()
      .statusCode(201)
      .body("isbn_13", startsWith("13-"))
      .body("title", is("Dark Matter"))
      .body("author", is("Blake Crouch"))
      .body("year", is(2016))
      .body("genre", is("Sci-Fi"));
  }

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
      .get("/api/books/13-dummy-isbn13-1")
    .then()
      .statusCode(200)
      .body("isbn_13", startsWith("13-"))
      .body("title", is("Dark Matter"))
      .body("author", is("Blake Crouch"))
      .body("genre", is("Sci-Fi"));
  }

}