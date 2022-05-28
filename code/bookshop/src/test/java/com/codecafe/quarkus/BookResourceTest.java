package com.codecafe.quarkus;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class BookResourceTest {

  @Test
  void testGetAllBooks() {
    given()
      .when().get("/api/books")
      .then()
      .statusCode(200);
  }

}