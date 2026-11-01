# k8s-java8

A small Java 8 + Maven sample project (an inventory and order-pricing model) used as a build target for
[k8s-platform](https://github.com/tanmaypatil/k8s-platform).

The build agent there reads `maven.compiler.source` / `maven.compiler.target` = `1.8` from `pom.xml`
and runs the build in the `java8-maven` image.

```bash
mvn -B package          # compile, test, build target/inventory-java8-1.0.0.jar
java -jar target/inventory-java8-1.0.0.jar
```
