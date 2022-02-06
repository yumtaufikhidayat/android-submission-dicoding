package com.taufik.movieshow.data.source.remote.response

data class OtherMoviesResponse (
    var detailMovieId: String,
    var movieId: String,
    var title: String,
    var imagePoster: String,
    var year: String,
    var rating: Double,
    var position: Int
)