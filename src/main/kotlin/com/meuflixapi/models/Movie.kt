package com.meuflixapi.models

import javax.persistence.*

@Entity
data class Movie(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null,
    @ManyToOne
    var genre: Genre?,
    var title : String,
    var imageLink : String,
    var actors :  String,
    var review : String
    )
