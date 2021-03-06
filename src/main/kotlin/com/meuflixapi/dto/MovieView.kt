package com.meuflixapi.dto


data class MovieView(
    val id : Long? = null,
    val genre : String? = null,
    val name : String,
    val urlImage : String,
    val cast : String,
    val description : String
)
