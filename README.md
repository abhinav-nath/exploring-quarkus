# [Quarkus](https://quarkus.io/ "Quarkus") - Supersonic/Subatomic/Java

**Developer(s)    :** Red Hat

**Initial release :** 20 March 2019; 3 years ago

## Extension Mechanism

- Very small core
- Everything else is an extension
- Supported by Quarkus
- Maintained by the community
- Create your own extension

<img width="50%" alt="quarkus-extensions" src="https://user-images.githubusercontent.com/48696735/170743664-3863cd51-a0b5-4953-bab1-829a6de6e256.png">

## GraalVM and Native Images

GraalVM is a Java Virtual Machine for compiling and running applications written in different languages to a native machine binary.

Quarkus' design accounted for native compilation from the onset.
It was optimized for using the native image capability of GraalVM to compile JVM bytecode to a native machine binary.

GraalVM aggressively removes any unreachable code found within the application's source code as well as any of its dependencies.
Combined with Linux containers and Kubernetes, a Quarkus application runs as a native Linux executable, eliminating the JVM.

A Quarkus native executable starts much faster and uses far less memory than a traditional JVM.

- Executable JARs contain bytecode hence they need the JVM to run.

- Native images contain binary, the needed JVM is bundled.

### Build a native executable

```
./gradlew build -Dquarkus.package.type=native
```

## JAX-RS and RESTEasy

**JAX-RS** - Java API for RESTful Web Services

Specification for

- Exposing REST Web Services
- Consuming REST Web Services

Implemented by RESTEasy

RESTEasy is a Quarkus extension

## Quarkus Dev UI

http://localhost:8030

<img width="70%" alt="quarkus-ui" src="https://user-images.githubusercontent.com/48696735/170825052-48142a1a-5b41-4915-b167-36aab3d894f3.png">

Click on "VISIT THE DEV UI"

<img width="70%" alt="quarkus-dev-ui" src="https://user-images.githubusercontent.com/48696735/170825055-27774823-b4c3-4ea1-89bb-3808ad3e67f7.png">

## Quarkus Profiles

Profile based properties at a single place (application.properties)

```
books.genre=Programming
%dev.books.genre=Horror
%test.books.genre=Sci-Fi
%staging.books.genre=Information Technology
```

To choose a profile while starting up Quarkus:

```
./gradlew quarkusDev -Dquarkus.profile=staging
```
