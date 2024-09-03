package com.vjammi.graphql.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class Review(
    @JsonProperty("id")
    val id: String,

    @JsonProperty("title")
    val title: String,

    @JsonProperty("description")
    val description: String? = null
)
