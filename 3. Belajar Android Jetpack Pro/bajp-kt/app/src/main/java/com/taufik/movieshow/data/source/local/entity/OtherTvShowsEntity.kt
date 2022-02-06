package com.taufik.movieshow.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "othertvshowsentities",
    primaryKeys = ["detailTvShowsId", "tvShowId"],
    foreignKeys = [ForeignKey(
        entity = TvShowEntity::class,
        parentColumns = ["tvShowId"],
        childColumns = ["tvShowId"]
    )],
    indices = [Index(value = ["detailTvShowsId"]), Index(value = ["tvShowId"])]
)
data class OtherTvShowsEntity(
    @NonNull
    @ColumnInfo(name = "detailTvShowsId")
    var detailTvShowsId: String,

    @NonNull
    @ColumnInfo(name = "tvShowId")
    var tvShowId: String,

    @NonNull
    @ColumnInfo(name = "title")
    var title: String,

    @NonNull
    @ColumnInfo(name = "imagePoster")
    var imagePoster: String,

    @NonNull
    @ColumnInfo(name = "year")
    var year: String,

    @NonNull
    @ColumnInfo(name = "rating")
    var rating: Double,

    @NonNull
    @ColumnInfo(name = "position")
    var position: Int,

    @ColumnInfo(name = "read")
    var read: Boolean = false
)