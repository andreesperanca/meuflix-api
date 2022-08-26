package com.meuflixapi.controller

import com.meuflixapi.dto.*
import com.meuflixapi.models.Movie
import com.meuflixapi.service.MovieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid


@RestController
@RequestMapping("/movies")

class MovieController
    (
    private val service : MovieService
    )
{

    @GetMapping("/{id}")
    fun findMovieById(@PathVariable id: Long): MovieView {
        return service.findMovieById(id)
    }


    @GetMapping
    fun listMovies(@RequestParam(required = false) genreName : String?) : List<MovieView> = service.listMovies(genreName)

    @PostMapping
    @Transactional
    fun registerMovie (@RequestBody @Valid formMovie: NewMovie, uriBuilder : UriComponentsBuilder)
            : ResponseEntity<MovieView> {
        val movieView = service.registerMovie(formMovie)
        val uri = uriBuilder.path("/movies/${movieView.id}").build().toUri()
        return ResponseEntity.created(uri).body(movieView)
    }

    @PutMapping
    @Transactional
    fun updateCategories(@RequestBody @Valid updateMovie: UpdateMovieForm): ResponseEntity<MovieView> {
        val movieView = service.updateMovie(updateMovie)
        return ResponseEntity.ok(movieView)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCategory(@PathVariable id: Long) {
        service.deleteMovie(id)
    }


}