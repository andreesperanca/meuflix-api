package com.meuflixapi.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateMovieForm(
    val id : Long,
    @field:NotNull
    val title: String,
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val imageLink : String,
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val actors : String,
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val review : String
)