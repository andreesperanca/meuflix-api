package com.meuflixapi.service

import com.meuflixapi.dto.MovieView
import com.meuflixapi.dto.NewMovie
import com.meuflixapi.mapper.NewMovieForMovie
import com.meuflixapi.mapper.MovieForMovieView
import com.meuflixapi.models.Movie
import org.springframework.stereotype.Service


@Service
class MovieService
    (
    private var moviesList : List<Movie> = emptyList(),
    private val movieViewMapper: MovieForMovieView,
    private val movieFormMapper: NewMovieForMovie
    )
{

    fun findMovieById (id: Long) : Movie {
        return moviesList.first { movie -> movie.idCategory == id }
    }

    fun listMovies(): List<MovieView> {
        return moviesList.map { movie ->
            movieViewMapper.map(movie)
        }
    }

    fun registerMovie(formMovie: NewMovie): MovieView {
        val movie = movieFormMapper.map(formMovie)
        movie.id = moviesList.size.toLong() + 1
        moviesList = moviesList.plus(movie)

        val listCategories = CategoryService.singletonList.categoriesList
        listCategories.first { category -> category.id == movie.idCategory}.let { category ->
            category.listMovies = category.listMovies.plus(movie)
        }
        return movieViewMapper.map(movie)
    }

    fun updateMovie( newMovie : Movie): MovieView? {
        val oldMovie = moviesList.first { it.id == newMovie.id }

        val updateMovie = Movie(
            id = newMovie.id,
            idCategory = newMovie.idCategory ?: oldMovie.idCategory,
            name = newMovie.name ?: oldMovie.name,
            urlImage = newMovie.urlImage ?: oldMovie.urlImage,
            cast = newMovie.cast ?: oldMovie.cast,
            description = newMovie.description ?: oldMovie.description
        )

        moviesList = moviesList.minus(oldMovie).plus(updateMovie)
        return movieViewMapper.map(updateMovie)
    }

    fun deleteMovie(id: Long) {
        val movie = moviesList.first { movie-> movie.id == id }
        moviesList = moviesList.minus(movie)
    }
}
