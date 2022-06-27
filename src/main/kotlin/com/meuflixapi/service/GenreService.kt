package com.meuflixapi.service

import com.meuflixapi.dto.GenreView
import com.meuflixapi.dto.NewGenre
import com.meuflixapi.dto.UpdateGenreForm
import com.meuflixapi.exception.NotFoundException
import com.meuflixapi.mapper.GenreForGenreView
import com.meuflixapi.mapper.NewGenreViewForGenre
import com.meuflixapi.repository.GenreRepository
import org.springframework.stereotype.Service

@Service
class GenreService(
    private val genreForGenreView: GenreForGenreView,
    private val newGenreViewForGenre: NewGenreViewForGenre,
    private val notFoundMessage: String = "Não encontrado",
    private val repository: GenreRepository
) {

    public val repository1
    get() = this.repository


    fun findCategoryById (id: Long) : GenreView {
        val genre  = repository.findById(id).orElseThrow {NotFoundException(notFoundMessage)}
        return genreForGenreView.map(genre)
    }

    fun listCategories(): List<GenreView> {
        return repository.findAll().map { category ->
            genreForGenreView.map(category)
        }
    }

    fun register(formCategory: NewGenre): GenreView {
        val genre = newGenreViewForGenre.map(formCategory)
        repository.save(genre)
        return genreForGenreView.map(genre)
    }

    fun updateCategories(formCategory: UpdateGenreForm): GenreView? {
        val genre = repository.findById(formCategory.id).orElseThrow {NotFoundException(notFoundMessage)}
        genre.title = formCategory.name
        return genreForGenreView.map(genre)
    }

    fun deleteCategory(id: Long) {
        val genre = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
        genre.listMovies = emptyList()
        repository.deleteById(id)
    }
}
