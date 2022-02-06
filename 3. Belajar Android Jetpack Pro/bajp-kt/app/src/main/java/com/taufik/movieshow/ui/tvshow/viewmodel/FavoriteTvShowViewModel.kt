package com.taufik.movieshow.ui.tvshow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.taufik.movieshow.data.MovieShowRepository
import com.taufik.movieshow.data.source.local.entity.TvShowEntity

class FavoriteTvShowViewModel(private val movieShowRepository: MovieShowRepository) : ViewModel() {

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> = movieShowRepository.getFavoritedTvShows()

    fun setFavorite(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.favorited
        movieShowRepository.setTvShowFavorite(tvShowEntity, newState)
    }
}