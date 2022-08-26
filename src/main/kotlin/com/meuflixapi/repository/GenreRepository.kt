package com.meuflixapi.repository

import com.meuflixapi.dto.GenreView
import com.meuflixapi.models.Genre
import org.springframework.data.jpa.repository.JpaRepository

interface GenreRepository : JpaRepository<Genre, Long> {

    fun findByTitle (nameGenre: String) : List<Genre>

}