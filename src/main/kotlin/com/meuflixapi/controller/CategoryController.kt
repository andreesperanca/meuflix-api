package com.meuflixapi.controller

import com.meuflixapi.dto.CategoryView
import com.meuflixapi.dto.NewCategory
import com.meuflixapi.dto.UpdateCategoryForm
import com.meuflixapi.service.CategoryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid


@RestController
@RequestMapping("/categories")
class CategoryController (private val service : CategoryService){

    @GetMapping("/{id}")
    fun findCategoryById(@PathVariable id: Long): CategoryView {
        return service.findCategoryById(id)
    }

    @GetMapping
    fun listCategories() : List<CategoryView> = service.listCategories()

    @PostMapping
    fun registerCategory (@RequestBody @Valid formCategory: NewCategory, uriBuilder : UriComponentsBuilder)
    : ResponseEntity<CategoryView> {
        val categoryView = service.register(formCategory)
        val uri = uriBuilder.path("/categories/${categoryView.id}").build().toUri()
        return ResponseEntity.created(uri).body(categoryView)
    }

    @PutMapping
    fun updateCategories(@RequestBody @Valid formCategory: UpdateCategoryForm): ResponseEntity<CategoryView> {
        val topicoView = service.updateCategories(formCategory)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCategory(@PathVariable id: Long) {
        service.deleteCategory(id)
    }

}