package com.meuflixapi.service

import com.meuflixapi.dto.GenreView
import com.meuflixapi.dto.NewGenre
import com.meuflixapi.dto.UpdateGenreForm
import com.meuflixapi.exception.NotFoundException
import com.meuflixapi.mapper.GenreForGenreView
import com.meuflixapi.mapper.NewGenreViewForGenre
import com.meuflixapi.repository.GenreRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestParam
import java.util.stream.Collectors

@Service
class GenreService(
    private val genreForGenreView: GenreForGenreView,
    private val newGenreViewForGenre: NewGenreViewForGenre,
    private val notFoundMessage: String = "Não encontrado",
    private val repository: GenreRepository
) {

    fun findGenreById (id: Long) : GenreView {
        val genre  = repository.findById(id).orElseThrow {NotFoundException(notFoundMessage)}
        return genreForGenreView.map(genre)
    }

    fun listGenre(genreName: String?): List<GenreView> {
        val genres = if(genreName == null) {
            repository.findAll()
        } else {
            repository.findByTitle(genreName)
        }

        return genres.stream().map { category ->
            genreForGenreView.map(category) }.collect(Collectors.toList())
    }

    fun register(formCategory: NewGenre): GenreView {
        val genre = newGenreViewForGenre.map(formCategory)
        repository.save(genre)
        return genreForGenreView.map(genre)
    }

    fun updateGenre(formCategory: UpdateGenreForm): GenreView? {
        val genre = repository.findById(formCategory.id).orElseThrow {NotFoundException(notFoundMessage)}
        genre.title = formCategory.name
        return genreForGenreView.map(genre)
    }

    fun deleteGenre(id: Long) {
        val genre = repository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
        genre.listMovies = emptyList()
        repository.deleteById(id)
    }
}
