package com.taufik.movieshow.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.taufik.movieshow.data.source.local.entity.*
import com.taufik.movieshow.data.source.local.room.MovieShowDao

class LocalDataSource private constructor(private val movieShowDao: MovieShowDao){

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieShowDao: MovieShowDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieShowDao)
    }

    fun getMovies(): DataSource.Factory<Int, MovieEntity> = movieShowDao.getMovies()

    fun getDetailMovie(movieId: String): LiveData<MovieWithOtherMovies> =
        movieShowDao.getDetailMovie(movieId)

    fun getAllOtherMoviesByMovie(movieId: String): LiveData<List<OtherMoviesEntity>> =
        movieShowDao.getOtherMoviesByMovieId(movieId)

    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity> = movieShowDao.getFavoriteMovies()

    fun insertMovies(movies: List<MovieEntity>) = movieShowDao.insertMovies(movies)

    fun insertOtherMovies(otherMovies: List<OtherMoviesEntity>) = movieShowDao.insertOtherMovies(otherMovies)

    fun setMovieFavorite(movie: MovieEntity, newState: Boolean){
        movie.favorited = newState
        movieShowDao.updateMovies(movie)
    }

    fun getTvShows(): DataSource.Factory<Int, TvShowEntity> = movieShowDao.getTvShows()

    fun getDetailTvShow(tvShowId: String): LiveData<TvShowWithOtherTvShows> =
        movieShowDao.getDetailTvShow(tvShowId)

    fun getAllOtherTvShowsByTvShow(tvShowId: String): LiveData<List<OtherTvShowsEntity>> =
        movieShowDao.getOtherTvShowsByTvShowId(tvShowId)

    fun getFavoriteTvShows(): DataSource.Factory<Int, TvShowEntity> = movieShowDao.getFavoriteTvShows()

    fun insertTvShows(tvShows: List<TvShowEntity>) = movieShowDao.insertTvShows(tvShows)

    fun insertOtherTvShows(otherTvShows: List<OtherTvShowsEntity>) = movieShowDao.insertOtherTvShows(otherTvShows)

    fun setTvShowFavorite(tvShow: TvShowEntity, newState: Boolean){
        tvShow.favorited = newState
        movieShowDao.updateTvShows(tvShow)
    }
}