package com.codecafe.quarkus.repository;

import com.codecafe.quarkus.model.Book;

import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

  @Inject
  Logger logger;

  public List<Book> getAllBooks() {
    logger.info("==> inside getAllBooks method");
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
    logger.info("==> inside countAllBooks method");
    return getAllBooks().size();
  }

  public Optional<Book> getBook(int id) {
    logger.info("==> inside getBook method with id : " + id);
    return getAllBooks()
      .stream()
      .filter(b -> b.getId() == id)
      .findFirst();
  }

}
