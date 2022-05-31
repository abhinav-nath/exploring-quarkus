package com.codecafe.quarkus.microservices.book.model;

import java.time.Instant;

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
public class Book {

  private String isbn13;
  private String title;
  private String author;
  private int yearOfPublication;
  private String genre;
  private Instant createdAt;

}