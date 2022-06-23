package com.meuflixapi.service

import com.meuflixapi.dto.CategoryView
import com.meuflixapi.dto.NewCategory
import com.meuflixapi.dto.UpdateCategoryForm
import com.meuflixapi.mapper.NewCategoryViewForCategory
import com.meuflixapi.mapper.CategoryForCategoryView
import com.meuflixapi.models.Category
import com.meuflixapi.service.CategoryService.singletonList.categoriesList
import org.springframework.stereotype.Service

@Service
class CategoryService(
    private val categoryViewMapper: CategoryForCategoryView,
    private val categoryFormMapper: NewCategoryViewForCategory,
) {

    object singletonList {
        var categoriesList : List<Category> = emptyList()
    }


    fun findCategoryById (id: Long) : CategoryView {
        val category = categoriesList.first { category ->
            category.id == id
        }
        return categoryViewMapper.map(category)
    }

    fun listCategories(): List<CategoryView> {
        return categoriesList.map { category ->
            categoryViewMapper.map(category)
        }
    }

    fun register(formCategory: NewCategory): CategoryView {
        val category = categoryFormMapper.map(formCategory)
        category.id = categoriesList.size.toLong() + 1
        categoriesList = categoriesList.plus(category)
        return categoryViewMapper.map(category)
    }

    fun updateCategories(formCategory: UpdateCategoryForm): CategoryView? {
        val category = categoriesList.first { it.id == formCategory.id }

        val updateCategory = Category(
            id = category.id,
            name = formCategory.name,
            listMovies = category.listMovies,
            createdTime = category.createdTime
        )
        categoriesList = categoriesList.minus(category).plus(updateCategory)
        return categoryViewMapper.map(updateCategory)
    }

    fun deleteCategory(id: Long) {
        val category = categoriesList.first {
            it.id == id
        }
        categoriesList = categoriesList.minus(category)
    }
}
