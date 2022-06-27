package com.meuflixapi.mapper

import com.meuflixapi.dto.NewMovie
import com.meuflixapi.models.Genre
import com.meuflixapi.models.Movie
import org.springframework.stereotype.Component
import java.time.LocalDateTime


@Component
class NewMovieForMovie () : Mapper<NewMovie, Movie>
{
    override fun map(t: NewMovie): Movie =
        Movie(title = t.name, id = t.id, imageLink = t.urlImage, actors = t.cast,
            review = t.description, genre = null)
}
