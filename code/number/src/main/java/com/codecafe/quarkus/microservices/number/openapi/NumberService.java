package com.codecafe.quarkus.microservices.number.openapi;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationPath("/")
@OpenAPIDefinition(
  info = @Info(title = "Number Service",
    description = "This microservice generates book numbers",
    version = "1.0.0",
    contact = @Contact(name = "@codecafe", url = "https://www.google.com")),
  externalDocs = @ExternalDocumentation(url = "https://github.com/abhinav-nath/exploring-quarkus/tree/master/code/number", description = "Code for Number Service"),
  tags = {
    @Tag(name = "api", description = "Public API that can be used to learn Quarkus"),
    @Tag(name = "numbers", description = "To be consumed by the Book Service")
  }
)
public class NumberService extends Application {

}