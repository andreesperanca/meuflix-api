package com.meuflixapi.service

import com.meuflixapi.dto.*
import com.meuflixapi.exception.NotFoundException
import com.meuflixapi.mapper.NewMovieForMovie
import com.meuflixapi.mapper.MovieForMovieView
import com.meuflixapi.repository.GenreRepository
import com.meuflixapi.repository.MovieRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors


@Service
class MovieService
    (
    private val genreRepository : GenreRepository,
    private val repository: MovieRepository,
    private val movieForMovieView: MovieForMovieView,
    private val newMovieForMovie: NewMovieForMovie,
    private val notFoundExceptionMessage : String = "Não encontrado"
    )
{

    fun findMovieById (id: Long) : MovieView {
        val movie = repository.findById(id).orElseThrow {NotFoundException(notFoundExceptionMessage)}
        return movieForMovieView.map(movie)
    }

    fun listMovies(genreName : String?): List<MovieView> {
        val movies = if (genreName == null) {
            repository.findAll()
        } else {
            repository.findByGenreTitle(genreName)
        }
        return movies.stream().map { movie ->
            movieForMovieView.map(movie)
        }.collect(Collectors.toList())
    }
    fun registerMovie(newMovie: NewMovie): MovieView {
        val movie = newMovieForMovie.map(newMovie)
        genreRepository.findById(newMovie.idGenre)
            .orElseThrow{NotFoundException("Categoria não encontrada.")}.let {genre ->
                movie.genre = genre
            }
        repository.save(movie)
        return movieForMovieView.map(movie)
    }

    fun updateMovie( newMovie : UpdateMovieForm): MovieView {
        val movie = repository.findById(newMovie.id).orElseThrow{NotFoundException(notFoundExceptionMessage)}

        movie.title = newMovie.title
        movie.imageLink = newMovie.imageLink
        movie.actors = newMovie.actors
        movie.review = newMovie.review
        return movieForMovieView.map(movie)
    }

    fun deleteMovie(id: Long) = repository.deleteById(id)
}
