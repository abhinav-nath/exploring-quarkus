package com.codecafe.quarkus.microservices.number.resource;

import com.codecafe.quarkus.microservices.number.model.IsbnNumbers;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.time.Instant;
import java.util.Random;

@Path("/api/numbers")
@Tag(name = "Number REST Endpoint")
public class NumberResource {

  @Inject
  Logger logger;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(
    summary = "Generates book numbers",
    description = "Generates ISBN 13 and ISBN 10 numbers"
  )
  public IsbnNumbers generateIsbnNumbers() {
    IsbnNumbers isbnNumbers = IsbnNumbers.builder()
                                         .isbn13("13-" + new Random().nextInt(100_000_000))
                                         .isbn10("10-" + new Random().nextInt(100_000))
                                         .generatedAt(Instant.now())
                                         .build();
    logger.info("Generated isbnNumbers : " + isbnNumbers);
    return isbnNumbers;
  }

}