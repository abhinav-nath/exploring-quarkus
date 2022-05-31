package com.codecafe.quarkus.microservices.book.model;

import lombok.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;

import java.time.Instant;

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

  @JsonbProperty("year")
  private int yearOfPublication;

  private String genre;

  @JsonbDateFormat("yyyy-MM-dd")
  @Schema(implementation = String.class, format = "date")
  private Instant createdAt;

}