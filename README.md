# Exploring Quarkus

**Developer(s)    :** Red Hat

**Initial release :** 20 March 2019; 3 years ago

## GraalVM

GraalVM is a Java Virtual Machine for compiling and running applications written in different languages to a native machine binary.

Quarkus' design accounted for native compilation from the onset.
It was optimized for using the native image capability of GraalVM to compile JVM bytecode to a native machine binary.

GraalVM aggressively removes any unreachable code found within the application's source code as well as any of its dependencies.
Combined with Linux containers and Kubernetes, a Quarkus application runs as a native Linux executable, eliminating the JVM.

A Quarkus native executable starts much faster and uses far less memory than a traditional JVM.
