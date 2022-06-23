package com.meuflixapi.dto

import com.meuflixapi.models.Movie
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateMovieForm(
    var id: Long? = null,
    val idCategory: Long?= null,
    val name: String?= null,
    val urlImage: String?= null,
    val cast: String?= null,
    val description: String? = null
)
