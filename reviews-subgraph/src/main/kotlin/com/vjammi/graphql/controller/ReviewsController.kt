package com.vjammi.graphql.controller

import com.vjammi.graphql.model.BookStub
import com.vjammi.graphql.model.Review
import com.vjammi.graphql.service.ReviewsService
import org.springframework.graphql.data.method.annotation.SchemaMapping
import org.springframework.stereotype.Controller

@Controller
class ReviewsController(private val service: ReviewsService) {

    @SchemaMapping(typeName = "Book", field = "reviews")
    fun reviews(bookStub: BookStub): List<Review?>? {
        print(bookStub)
        val reviews = service.getReviews(bookStub)
        return reviews
    }
}
