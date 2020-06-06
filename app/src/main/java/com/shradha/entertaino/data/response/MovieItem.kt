package com.shradha.entertaino.data.response

data class MovieItem(
    val genre: List<String>,
    val image: String,
    val rating: Double,
    val releaseYear: Int,
    val title: String
)