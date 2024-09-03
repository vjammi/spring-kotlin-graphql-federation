# spring-kotlin-graphql-federation

### References
    https://www.baeldung.com/kotlin/spring-boot-crud-api
    https://kotlinlang.org/docs/jvm-get-started-spring-boot.html
    https://www.baeldung.com/kotlin/mockito
### Introduction to building Kotlin GraphQL services with Spring Boot
    https://youtu.be/SzrvH6igbbU
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