package com.codecafe.quarkus;

import com.codecafe.quarkus.model.Book;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/api/books")
@Produces(APPLICATION_JSON)
public class BookResource {

    @GET
    public List<Book> getAllBooks() {
        return List.of(Book.builder()
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

}