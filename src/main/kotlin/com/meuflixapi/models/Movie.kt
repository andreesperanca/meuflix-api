package com.meuflixapi.models

data class Movie (
    var id : Long?,
    val idCategory : Long,
    val name : String,
    val urlImage : String,
    val cast : String,
    val description : String
    )