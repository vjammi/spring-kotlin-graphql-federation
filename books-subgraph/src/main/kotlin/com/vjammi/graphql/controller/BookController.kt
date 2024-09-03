package com.vjammi.graphql.controller

import com.vjammi.graphql.model.Book
import com.vjammi.graphql.model.Review
import com.vjammi.graphql.service.BookService
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class BookController(private val service: BookService) {

    @QueryMapping
    fun books(): Collection<Book> {
        return service.getBooks()
    }

}
