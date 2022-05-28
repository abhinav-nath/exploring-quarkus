package com.codecafe.quarkus.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

  private int id;
  private String title;
  private String author;
  private int yearOfPublication;
  private String genre;

}