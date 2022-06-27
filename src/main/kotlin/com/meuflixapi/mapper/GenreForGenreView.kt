package com.meuflixapi.mapper

import com.meuflixapi.dto.GenreView
import com.meuflixapi.dto.MovieView
import com.meuflixapi.models.Genre
import org.springframework.stereotype.Component

@Component
class GenreForGenreView : Mapper<Genre, GenreView>
{
    override fun map(t: Genre): GenreView =
        GenreView(name = t.title, id = t.id, listMovies = t.listMovies.map {
            movie ->
            MovieView(
                id = movie.id,
                genre = movie.genre?.title,
                name = movie.title,
                urlImage = movie.imageLink,
                cast = movie.actors,
                description = movie.review
            )
        })
}