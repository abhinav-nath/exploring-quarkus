package com.codecafe.quarkus.resource;

import javax.ws.rs.core.MediaType;

import io.quarkus.test.junit.QuarkusIntegrationTest;

import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusIntegrationTest
public class BookResourceIntegrationTest extends BookResourceTest {

  // Execute the same tests but in native mode.

  // Override the test
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
      .body("genre", is("Programming"));
  }

}
