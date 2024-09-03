package com.vjammi.graphql.service

import com.vjammi.graphql.dto.ReviewsDataStore
import com.vjammi.graphql.model.BookStub
import com.vjammi.graphql.model.Review
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ReviewsService (private val datastore: ReviewsDataStore){

    fun getReviews(bookStub: BookStub?): List<Review?>? {
        return datastore.retrieveReviews()
    }

}
