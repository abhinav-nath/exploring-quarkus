package com.codecafe.quarkus.microservices.number;

import java.time.Instant;
import java.util.Random;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;

import com.codecafe.quarkus.microservices.number.model.IsbnNumbers;

@Path("/api/numbers")
public class NumberResource {

  @Inject
  Logger logger;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
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