package com.codecafe.quarkus.resource;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.codecafe.quarkus.model.Book;
import com.codecafe.quarkus.repository.BookRepository;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/api/books")
@Produces(APPLICATION_JSON)
public class BookResource {

  @Inject
  BookRepository bookRepository;

  @GET
  public List<Book> getAllBooks() {
    return bookRepository.getAllBooks();
  }

  @GET
  @Path("/count")
  @Produces(TEXT_PLAIN)
  public int countAllBooks() {
    return bookRepository.countAllBooks();
  }

  @GET
  @Path("/{id}")
  public Optional<Book> getBook(@PathParam("id") int id) {
    return bookRepository.getBook(id);
  }

}