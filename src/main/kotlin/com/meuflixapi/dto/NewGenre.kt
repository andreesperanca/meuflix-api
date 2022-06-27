package com.meuflixapi.dto

import com.meuflixapi.models.Movie
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size


data class NewGenre (
    @field:NotEmpty(message = "Titulo nao pode ser em branco")
    @field:Size(min = 5, max = 100, message = "Titulo deve ter entre 5 e 100 caracteres")
    val name: String,
    val listMovies : List<Movie> = emptyList()
)