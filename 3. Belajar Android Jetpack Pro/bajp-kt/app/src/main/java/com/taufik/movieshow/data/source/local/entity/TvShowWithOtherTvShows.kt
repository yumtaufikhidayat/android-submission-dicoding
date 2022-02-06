package com.taufik.movieshow.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class TvShowWithOtherTvShows(
    @Embedded
    var mTvShows: TvShowEntity,

    @Relation(parentColumn = "tvShowId", entityColumn = "tvShowId")
    var mOtherTvShows: List<OtherTvShowsEntity>
)