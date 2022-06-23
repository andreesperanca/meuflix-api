package com.meuflixapi.controller

import com.meuflixapi.dto.*
import com.meuflixapi.models.Movie
import com.meuflixapi.service.MovieService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid


@RestController
@RequestMapping("/movies")

class MovieController
    (
    private val service : MovieService
    )
{

    @GetMapping("/{id}")
    fun findMovieById(@PathVariable id: Long): Movie {
        return service.findMovieById(id)
    }


    @GetMapping
    fun listMovies() : List<MovieView> = service.listMovies()

    @PostMapping
    fun registerMovie (@RequestBody @Valid formMovie: NewMovie, uriBuilder : UriComponentsBuilder)
            : ResponseEntity<MovieView> {
        val movieView = service.registerMovie(formMovie)
        val uri = uriBuilder.path("/movies/${movieView.id}").build().toUri()
        return ResponseEntity.created(uri).body(movieView)
    }

    @PutMapping
    fun updateCategories(@RequestBody @Valid movie: Movie): ResponseEntity<MovieView> {
        val movieView = service.updateMovie(movie)
        return ResponseEntity.ok(movieView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCategory(@PathVariable id: Long) {
        service.deleteMovie(id)
    }


}