package com.vjammi.graphql.service

import com.vjammi.graphql.model.Book
import com.vjammi.graphql.model.Review
import org.springframework.stereotype.Service
import java.util.UUID

@Service
//class BankService(@Qualifier("mock") private val dataSource: BankDataSource) {
class BookService{

    //fun getBooks(): Collection<Book> = dataSource.retrieveBanks()

    fun getBooks(): Collection<Book> {
        return listOf(
            Book(
                id = UUID.randomUUID().toString(),
                title = "Algorithms in Kotlin",
                description = "Algorithms by Author 1"
            ),
            Book(
                id = UUID.randomUUID().toString(),
                title = "Algorithms in Java",
                description = "Algorithms by Author 2"
            ),
            Book(
                id = UUID.randomUUID().toString(),
                title = "Algorithms in Golang",
                description = "Algorithms by Author 3"
            )
        )
    }

    fun getReviews(productStub: Book?): List<Review?>? {
        return listOf(
            Review(
                id = UUID.randomUUID(),
                title = "Algorithms in Kotlin",
                description = "Algorithms by Author 1"
            ),
            Review(
                id = UUID.randomUUID(),
                title = "Algorithms in Java",
                description = "Algorithms by Author 2"
            ),
            Review(
                id = UUID.randomUUID(),
                title = "Algorithms in Golang",
                description = "Algorithms by Author 3"
            )
        )

    }
}
