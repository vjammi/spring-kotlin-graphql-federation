package com.vjammi.graphql.dto

import com.vjammi.graphql.model.Review
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ReviewsDataStore {
    fun retrieveReviews(): List<Review> {
        val reviews = listOf(
            Review(
                id = UUID.randomUUID().toString(),
                title = "Algorithms in Kotlin",
                description = "Algorithms by Author 1"
            ),
            Review(
                id = UUID.randomUUID().toString(),
                title = "Algorithms in Java",
                description = "Algorithms by Author 2"
            ),
            Review(
                id = UUID.randomUUID().toString(),
                title = "Algorithms in Golang",
                description = "Algorithms by Author 3"
            )
        )
        return reviews
    }
}