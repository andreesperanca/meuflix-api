package com.meuflixapi.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NewMovie(
    @field:NotEmpty(message = "Campo nome não pode ser vazio.")
    @field:Size(min = 1, max = 100, message = "Nome deve ter entre 1 e 25 caracteres")
    val name: String,
    @field:NotNull
    val id: Long,
    @field:NotNull
    val idGenre: Long,
    @field:NotNull
    val cast : String,
    @field:NotNull
    val urlImage : String,
    @field:NotNull
    val description : String
)