package com.meuflixapi.repository

import com.meuflixapi.models.Genre
import com.meuflixapi.models.Movie
import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository : JpaRepository<Movie, Long> {
    fun findByGenreTitle(genreName : String) : List<Movie>
}