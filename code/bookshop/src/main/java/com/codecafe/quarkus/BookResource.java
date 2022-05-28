package com.codecafe.quarkus;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.codecafe.quarkus.model.Book;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/api/books")
@Produces(APPLICATION_JSON)
public class BookResource {

  @GET
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

  @GET
  @Path("/count")
  @Produces(TEXT_PLAIN)
  public int countAllBooks() {
    return getAllBooks().size();
  }

  @GET
  @Path("/{id}")
  public Optional<Book> getBook(@PathParam("id") int id) {
    return getAllBooks()
      .stream()
      .filter(b -> b.getId() == id)
      .findFirst();
  }

}