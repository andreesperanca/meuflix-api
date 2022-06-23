package com.meuflixapi.mapper

interface Mapper<R, D> {

    fun map (t : R) : D

}