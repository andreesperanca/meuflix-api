package com.meuflixapi.controller

import com.meuflixapi.dto.GenreView
import com.meuflixapi.dto.NewGenre
import com.meuflixapi.dto.UpdateGenreForm
import com.meuflixapi.service.GenreService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid


@RestController
@RequestMapping("/categories")
class GenreController (private val service : GenreService){

    @GetMapping("/{id}")
    fun findCategoryById(@PathVariable id: Long): GenreView {
        return service.findCategoryById(id)
    }

    @GetMapping
    fun listCategories() : List<GenreView> = service.listCategories()

    @PostMapping
    @Transactional
    fun registerCategory (@RequestBody @Valid formCategory: NewGenre, uriBuilder : UriComponentsBuilder)
    : ResponseEntity<GenreView> {
        val categoryView = service.register(formCategory)
        val uri = uriBuilder.path("/categories/${categoryView.id}").build().toUri()
        return ResponseEntity.created(uri).body(categoryView)
    }

    @PutMapping
    @Transactional
    fun updateCategories(@RequestBody @Valid formCategory: UpdateGenreForm): ResponseEntity<GenreView> {
        val topicoView = service.updateCategories(formCategory)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCategory(@PathVariable id: Long) {
        service.deleteCategory(id)
    }

}