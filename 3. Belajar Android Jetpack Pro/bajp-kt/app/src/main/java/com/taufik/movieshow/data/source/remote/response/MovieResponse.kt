package com.taufik.movieshow.data.source.remote.response

data class MovieResponse(
    val imageBackdrop: String,
    val id: String,
    val language: String,
    val overview: String,
    val imagePoster: String,
    val releaseDate: String,
    val title: String,
    val rating: Double,
    val homePage: String
)
