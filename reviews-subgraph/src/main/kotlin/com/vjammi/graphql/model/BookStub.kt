package com.vjammi.graphql.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class BookStub(
    @JsonProperty("id")
    val id: String
)
