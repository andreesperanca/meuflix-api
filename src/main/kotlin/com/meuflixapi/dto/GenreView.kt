package com.meuflixapi.dto

data class GenreView(
    val id: Long?,
    val name : String,
    var listMovies : List<MovieView>? = null
)
