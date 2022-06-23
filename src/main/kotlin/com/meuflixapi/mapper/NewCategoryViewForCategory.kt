package com.meuflixapi.mapper

import com.meuflixapi.dto.NewCategory
import com.meuflixapi.models.Category
import com.meuflixapi.models.Movie
import org.springframework.stereotype.Component
import javax.swing.event.CaretEvent


@Component
class NewCategoryViewForCategory () : Mapper<NewCategory, Category>
{
    val movie = Movie(name = "Leite", id = 3, idCategory = 1, cast = "Andre", urlImage = "", description = "")

    override fun map(t: NewCategory) : Category {
     return Category(name = t.name, listMovies = t.listMovies)
    }
}

