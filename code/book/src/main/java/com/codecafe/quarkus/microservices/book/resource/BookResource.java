package com.codecafe.quarkus.microservices.book.resource;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.codecafe.quarkus.microservices.book.model.Book;
import com.codecafe.quarkus.microservices.book.repository.BookRepository;

import static javax.ws.rs.core.MediaType.APPLICATION_FORM_URLENCODED;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("/api/books")
@Produces(APPLICATION_JSON)
@Tag(name = "Book REST endpoint")
public class BookResource {

  @Inject
  BookRepository bookRepository;

  @POST
  @Produces(APPLICATION_JSON)
  @Consumes(APPLICATION_FORM_URLENCODED)
  @Operation(
    summary = "Creates a Book",
    description = "Creates a Book with an ISBN number"
  )
  public Response createABook(@FormParam("title") String title, @FormParam("author") String author, @FormParam("year") int yearOfPublication, @FormParam("genre") String genre) {
    Book book = bookRepository.createABook(title, author, yearOfPublication, genre);
    return Response.status(201).entity(book).build();
  }

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
  @Path("/{isbn13}")
  public Optional<Book> getBook(@PathParam("isbn13") String isbn13) {
    return bookRepository.getBook(isbn13);
  }

}