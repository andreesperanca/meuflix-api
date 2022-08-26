package com.meuflixapi.mapper

import com.meuflixapi.dto.MovieView
import com.meuflixapi.models.Movie
import org.springframework.stereotype.Component

@Component
class MovieForMovieView: Mapper<Movie, MovieView>
{
    override fun map(t: Movie): MovieView =
        MovieView(id = t.id, name = t.title, genre = t.genre?.title, urlImage = t.imageLink, cast = t.actors
            , description = t.review)
}