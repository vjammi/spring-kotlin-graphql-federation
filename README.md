# spring-kotlin-graphql-federation

## References
### Spring Boot - Kotlin
    https://www.baeldung.com/kotlin/spring-boot-crud-api
### Introduction to building Kotlin GraphQL services with Spring Boot
    https://youtu.be/SzrvH6igbbU
### How to test your GraphQL APIs
    https://youtu.be/0b0x3C_BTT8
### Mockito
    https://www.baeldung.com/kotlin/mockito
    https://kotlinlang.org/docs/jvm-get-started-spring-boot.html    
### Spring
    https://docs.spring.io/spring-graphql/reference/controllers.html

### Query
```graphql
    query{
      books{
        id
        title
        description
        reviews {
          id
          rating
        }
      }
    }

```