package com.meuflixapi.dto

data class MovieView(
    val id : Long? = null,
    val idCategory : Long? = null,
    val name : String,
    val urlImage : String,
    val cast : String,
    val description : String
)
