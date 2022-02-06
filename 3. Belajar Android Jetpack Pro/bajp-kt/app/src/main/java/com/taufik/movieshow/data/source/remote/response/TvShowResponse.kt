package com.taufik.movieshow.data.source.remote.response

data class TvShowResponse(
    val imageBackdrop: String,
    val firstAirDate: String,
    val id: String,
    val title: String,
    val language: String,
    val overview: String,
    val imagePoster: String,
    val rating: Double,
    val homePage: String
)
