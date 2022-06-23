package com.meuflixapi.models

import java.time.LocalDateTime

data class Category(
    val createdTime: LocalDateTime = LocalDateTime.now(),
    var id : Long? = null,
    val name : String,
    var listMovies : List<Movie> = emptyList<Movie>()
)