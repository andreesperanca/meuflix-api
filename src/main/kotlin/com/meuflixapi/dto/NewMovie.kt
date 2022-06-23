package com.meuflixapi.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NewMovie(
    @field:NotEmpty(message = "Titulo nao pode ser em branco")
    @field:Size(min = 5, max = 100, message = "Titulo deve ter entre 5 e 100 caracteres")
    val name: String,
    @field:NotNull
    val id: Long,
    @field:NotNull
    val idCategory: Long,
    @field:NotNull
    val cast : String,
    @field:NotNull
    val urlImage : String,
    @field:NotNull
    val description : String
)