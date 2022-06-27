package com.meuflixapi.repository

import com.meuflixapi.models.Genre
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface GenreRepository : JpaRepository<Genre, Long> {

}