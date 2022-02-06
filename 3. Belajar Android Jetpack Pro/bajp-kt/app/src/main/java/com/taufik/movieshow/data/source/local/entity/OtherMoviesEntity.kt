package com.taufik.movieshow.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "othermoviesentities",
    primaryKeys = ["detailMovieId", "movieId"],
    foreignKeys = [ForeignKey(
        entity = MovieEntity::class,
        parentColumns = ["movieId"],
        childColumns = ["movieId"]
    )],
    indices = [Index(value = ["detailMovieId"]), Index(value = ["movieId"])]
)
data class OtherMoviesEntity(
    @NonNull
    @ColumnInfo(name = "detailMovieId")
    var detailMovieId: String,

    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: String,

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