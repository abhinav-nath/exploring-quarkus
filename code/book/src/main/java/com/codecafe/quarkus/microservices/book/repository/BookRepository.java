package com.codecafe.quarkus.microservices.book.repository;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import com.codecafe.quarkus.microservices.book.model.Book;

import static java.time.Instant.now;

@ApplicationScoped
public class BookRepository {

  @ConfigProperty(name = "books.genre", defaultValue = "Sci-Fi")
  String genre;

  @Inject
  Logger logger;

  public Book createABook(String title, String author, int yearOfPublication, String genre) {
    Book book = Book.builder()
                    .isbn13("dummy-isbn13-1")
                    .title(title)
                    .author(author)
                    .yearOfPublication(yearOfPublication)
                    .genre(genre)
                    .createdAt(now())
                    .build();
    logger.info("Book created : " + book);
    return book;
  }

  public List<Book> getAllBooks() {
    logger.info("==> inside getAllBooks method");
    return List.of(
      Book.builder()
          .isbn13("dummy-isbn13-1")
          .title("Dark Matter")
          .author("Blake Crouch")
          .genre(genre)
          .yearOfPublication(2016)
          .build(),
      Book.builder()
          .isbn13("dummy-isbn13-2")
          .title("Effective Java")
          .author("Joshua Bloch")
          .genre(genre)
          .yearOfPublication(2001)
          .build());
  }

  public int countAllBooks() {
    logger.info("==> inside countAllBooks method");
    return getAllBooks().size();
  }

  public Optional<Book> getBook(String isbn13) {
    logger.info("==> inside getBook method with isbn13 : " + isbn13);
    return getAllBooks()
      .stream()
      .filter(b -> isbn13.equals(b.getIsbn13()))
      .findFirst();
  }

}