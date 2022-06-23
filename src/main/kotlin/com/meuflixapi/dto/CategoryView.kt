package com.meuflixapi.dto

import com.meuflixapi.models.Movie

data class CategoryView(
    val id: Long?,
    val name : String,
    var listMovies : List<Movie>? = null
)
