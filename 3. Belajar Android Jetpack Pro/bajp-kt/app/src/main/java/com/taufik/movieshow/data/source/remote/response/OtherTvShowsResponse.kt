package com.taufik.movieshow.data.source.remote.response

data class OtherTvShowsResponse (
    var detailTvShowId: String,
    var tvShowId: String,
    var title: String,
    var imagePoster: String,
    var year: String,
    var rating: Double,
    var position: Int
)