package com.codecafe.quarkus.microservices.number.model;

import java.time.Instant;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IsbnNumbers {

  @JsonbProperty("isbn_13")
  private String isbn13;

  @JsonbProperty("isbn_10")
  private String isbn10;

  @JsonbTransient
  private Instant generatedAt;

}
