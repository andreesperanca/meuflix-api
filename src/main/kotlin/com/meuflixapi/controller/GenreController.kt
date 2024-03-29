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
@RequestMapping("/genres")
class GenreController (private val service : GenreService){

    @GetMapping("/{id}")
    fun findGenreById(@PathVariable id: Long): GenreView {
        return service.findGenreById(id)
    }

    @GetMapping
    fun listGenre(@RequestParam(required = false) genreName: String?) : List<GenreView> = service.listGenre(genreName)

    @PostMapping
    @Transactional
    fun registerGenre (@RequestBody @Valid formCategory: NewGenre, uriBuilder : UriComponentsBuilder)
    : ResponseEntity<GenreView> {
        val categoryView = service.register(formCategory)
        val uri = uriBuilder.path("/genres/${categoryView.id}").build().toUri()
        return ResponseEntity.created(uri).body(categoryView)
    }

    @PutMapping
    @Transactional
    fun updateGenre(@RequestBody @Valid formCategory: UpdateGenreForm): ResponseEntity<GenreView> {
        val topicoView = service.updateGenre(formCategory)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteGenre(@PathVariable id: Long) {
        service.deleteGenre(id)
    }

}