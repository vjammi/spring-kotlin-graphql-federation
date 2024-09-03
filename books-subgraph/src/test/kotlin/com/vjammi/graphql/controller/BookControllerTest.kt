package com.vjammi.graphql.controller

import com.vjammi.graphql.model.Book
import com.vjammi.graphql.service.BookService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest
import org.springframework.context.annotation.Import
import org.springframework.graphql.test.tester.GraphQlTester

@GraphQlTest(BookController::class)
@Import(BookService::class)
internal class BookControllerTest @Autowired constructor (val graphQlTester: GraphQlTester){

    @Test
    fun `should return all books`() {
        val document = """
            query {
                  books{
                    id
                    title
                    description
                  }
            }            
        """;

        graphQlTester.document(document)
            .execute()
            .path("books")
            .entityList<Book>(Book::class.java)
            .hasSize(3);


        val books = graphQlTester.document(document)
            .execute()
            .path("books")
            .entityList<Book>(Book::class.java)
            .get()

        print(books.get(0))
    }
}