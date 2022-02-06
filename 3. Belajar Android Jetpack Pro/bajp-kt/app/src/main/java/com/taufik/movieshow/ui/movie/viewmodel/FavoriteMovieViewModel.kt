package com.taufik.movieshow.ui.movie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.taufik.movieshow.data.MovieShowRepository
import com.taufik.movieshow.data.source.local.entity.MovieEntity

class FavoriteMovieViewModel(private val movieShowRepository: MovieShowRepository) : ViewModel() {

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> = movieShowRepository.getFavoritedMovies()

    fun setFavorite(movieEntity: MovieEntity) {
        val newState = !movieEntity.favorited
        movieShowRepository.setMovieFavorite(movieEntity, newState)
    }
}