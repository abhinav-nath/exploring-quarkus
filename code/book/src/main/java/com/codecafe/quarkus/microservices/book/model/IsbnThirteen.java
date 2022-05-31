package com.codecafe.quarkus.microservices.book.model;

import javax.json.bind.annotation.JsonbProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IsbnThirteen {

  @JsonbProperty("isbn_13")
  private String isbn13;

}