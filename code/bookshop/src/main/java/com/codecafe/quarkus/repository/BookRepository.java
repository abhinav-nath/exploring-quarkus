package com.codecafe.quarkus.repository;

import com.codecafe.quarkus.model.Book;

import javax.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

  public List<Book> getAllBooks() {
    return List.of(
      Book.builder()
          .id(1)
          .title("Dark Matter")
          .author("Blake Crouch")
          .genre("Sci-Fi")
          .yearOfPublication(2016)
          .build(),
      Book.builder()
          .id(2)
          .title("Effective Java")
          .author("Joshua Bloch")
          .genre("Programming")
          .yearOfPublication(2001)
          .build());
  }

  public int countAllBooks() {
    return getAllBooks().size();
  }

  public Optional<Book> getBook(int id) {
    return getAllBooks()
      .stream()
      .filter(b -> b.getId() == id)
      .findFirst();
  }

}
