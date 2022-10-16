# Sales Tax
## Building

The project uses Maven as a build tool and requires according [setup](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html).
Once configured, the project is build and run using following set of commands:
```
cd demo
mvn package
java -cp target/demo-1.0-SNAPSHOT.jar salestax.App
```

## Assumptions

1. Assumptions about the input
    - assume that each input line is a subset of following regular expression: 
    `1 [a-zA-Z ]*[ at ][0-9]{2}.[0-9]{2}`
    - assume that keyword <i>imported</i> can appear maximum once within  section `[a-zA-Z ]`
