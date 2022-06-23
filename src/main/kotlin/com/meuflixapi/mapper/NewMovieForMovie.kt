package com.meuflixapi.mapper

import com.meuflixapi.dto.NewMovie
import com.meuflixapi.models.Movie
import org.springframework.stereotype.Component


@Component
class NewMovieForMovie () : Mapper<NewMovie, Movie>
{
    override fun map(t: NewMovie): Movie =
        Movie(name = t.name, idCategory = t.idCategory, urlImage = t.urlImage, cast = t.cast,
            description = t.description, id = t.id)
}
