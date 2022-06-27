package com.meuflixapi.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Genre(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,
    var title : String,
    val createdTime: LocalDateTime = LocalDateTime.now(),
    @OneToMany(mappedBy = "genre")
    var listMovies : List<Movie> = ArrayList()
)