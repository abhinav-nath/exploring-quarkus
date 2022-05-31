package com.codecafe.quarkus.microservices.book.model;

import java.time.Instant;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

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
@Schema(description = "Book object")
public class Book {

  @JsonbProperty("isbn_13")
  private String isbn13;

  private String title;
  private String author;

  private int yearOfPublication;
  private String genre;

  @JsonbDateFormat("yyyy-MM-dd")
  @Schema(implementation = String.class, format = "date")
  private Instant createdAt;

}