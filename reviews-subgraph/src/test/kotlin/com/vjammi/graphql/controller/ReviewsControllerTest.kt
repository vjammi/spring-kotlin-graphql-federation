package com.vjammi.graphql.controller

import com.vjammi.graphql.model.BookStub
import com.vjammi.graphql.model.Review
import com.vjammi.graphql.service.ReviewsService
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.util.*
import kotlin.test.assertNotNull

/**
 * Reference:
 *  https://www.baeldung.com/kotlin/mockito
 *
 * Mockito Dependencies
 * 	testImplementation("org.mockito:mockito-core:3.3.3")
 * 	testImplementation("org.mockito.kotlin:mockito-kotlin:5.4.0")
 *
 * */
internal class ReviewsControllerTest {

    @Test
    fun `when passed stubs should return reviews`() {
        val reviewsService = Mockito.mock(ReviewsService::class.java)
        Mockito.`when`(reviewsService. getReviews(Mockito.any())).thenReturn(getMockedReviews())
        val reviewsController = ReviewsController(reviewsService)

        val stub = BookStub("1234")
        val reviews = reviewsController.reviews(stub)
        assertNotNull(reviews)
    }

    @Test
    fun whenBookIsAvailable_thenLendMethodIsCalled() {
        val reviewsService : ReviewsService = mock()
        whenever(reviewsService.getReviews(Mockito.any())).thenReturn(getMockedReviews())
        val reviewsController = ReviewsController(reviewsService)
        val stub = BookStub("1234")
        reviewsController.reviews(stub)
        verify(reviewsService).getReviews(stub)
    }

    private fun getMockedReviews(): List<Review?>? {
        return listOf(
            Review(
                id = UUID.randomUUID().toString(),
                title = "Algorithms in Kotlin...",
                description = "Algorithms by Author 1"
            ),
            Review(
                id = UUID.randomUUID().toString(),
                title = "Algorithms in Java...",
                description = "Algorithms by Author 2"
            ),
            Review(
                id = UUID.randomUUID().toString(),
                title = "Algorithms in Golang...",
                description = "Algorithms by Author 3"
            )
        )
    }
}