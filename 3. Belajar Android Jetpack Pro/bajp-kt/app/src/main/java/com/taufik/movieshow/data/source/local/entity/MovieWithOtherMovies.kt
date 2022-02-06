package com.taufik.movieshow.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class MovieWithOtherMovies(
    @Embedded
    var mMovie: MovieEntity,

    @Relation(parentColumn = "movieId", entityColumn = "movieId")
    var mOtherMovies: List<OtherMoviesEntity>
)