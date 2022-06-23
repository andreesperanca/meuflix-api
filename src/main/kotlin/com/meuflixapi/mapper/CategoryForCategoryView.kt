package com.meuflixapi.mapper

import com.meuflixapi.dto.CategoryView
import com.meuflixapi.models.Category
import org.springframework.stereotype.Component

@Component
class CategoryForCategoryView: Mapper<Category, CategoryView>
{
    override fun map(t: Category): CategoryView =
        CategoryView(name = t.name, id = t.id, listMovies = t.listMovies)
}