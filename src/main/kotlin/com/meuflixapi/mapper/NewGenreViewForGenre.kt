package com.meuflixapi.mapper

import com.meuflixapi.dto.NewGenre
import com.meuflixapi.models.Genre
import org.springframework.stereotype.Component


@Component
class NewGenreViewForGenre () : Mapper<NewGenre, Genre>
{
    override fun map(t: NewGenre) : Genre {
     return Genre(title = t.name, listMovies = t.listMovies)
    }
}

