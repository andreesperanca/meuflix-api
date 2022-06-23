package com.meuflixapi.dto

import com.meuflixapi.models.Movie
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateCategoryForm(
    @field:NotNull
    val id: Long,
    @field:NotEmpty
    @field:Size(min = 5, max = 100)
    val name: String
)
