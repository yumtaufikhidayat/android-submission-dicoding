package com.taufik.movieshow.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.taufik.movieshow.data.source.local.entity.*
import com.taufik.movieshow.vo.Resource

interface MovieShowDataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getDetailMovie(movieId: String): LiveData<Resource<MovieWithOtherMovies>>

    fun getFavoritedMovies(): LiveData<PagedList<MovieEntity>>

    fun getAllOtherMoviesByMovie(movieId: String): LiveData<Resource<List<OtherMoviesEntity>>>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)

    fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getDetailTvShow(tvShowId: String): LiveData<Resource<TvShowWithOtherTvShows>>

    fun getFavoritedTvShows(): LiveData<PagedList<TvShowEntity>>

    fun getAllOtherTvShowsByTvShow(tvShowId: String): LiveData<Resource<List<OtherTvShowsEntity>>>

    fun setTvShowFavorite(tvShow: TvShowEntity, state: Boolean)
}