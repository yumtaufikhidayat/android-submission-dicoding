package com.taufik.movieshow.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.taufik.movieshow.data.source.local.entity.*

@Dao
interface MovieShowDao {

    @Query("SELECT * FROM movieentities")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Transaction
    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getDetailMovie(movieId: String): LiveData<MovieWithOtherMovies>

    @Query("SELECT * FROM movieentities WHERE favorited = 1")
    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOtherMovies(otherMovies: List<OtherMoviesEntity>)

    @Update
    fun updateMovies(movies: MovieEntity)

    @Update
    fun updateOtherMovie(otherMovies: OtherMoviesEntity)

    @Query("SELECT * FROM othermoviesentities WHERE movieId = :movieId")
    fun getOtherMoviesByMovieId(movieId: String): LiveData<List<OtherMoviesEntity>>

    @Query("SELECT * FROM tvshowentities")
    fun getTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Transaction
    @Query("SELECT * FROM tvshowentities WHERE tvShowId = :tvShowId")
    fun getDetailTvShow(tvShowId: String): LiveData<TvShowWithOtherTvShows>

    @Query("SELECT * FROM tvshowentities WHERE favorited = 1")
    fun getFavoriteTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShows(tvShows: List<TvShowEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOtherTvShows(otherTvShows: List<OtherTvShowsEntity>)

    @Update
    fun updateTvShows(tvShows: TvShowEntity)

    @Update
    fun updateOtherTvShow(otherTvShows: OtherTvShowsEntity)

    @Query("SELECT * FROM othertvshowsentities WHERE tvShowId = :tvShowId")
    fun getOtherTvShowsByTvShowId(tvShowId: String): LiveData<List<OtherTvShowsEntity>>
}