package com.taufik.movieshow.ui.tvshow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.taufik.movieshow.data.MovieShowRepository
import com.taufik.movieshow.data.source.local.entity.TvShowWithOtherTvShows
import com.taufik.movieshow.vo.Resource

class DetailTvShowViewModel(private val movieShowRepository: MovieShowRepository) : ViewModel() {

    private var tvShowId = MutableLiveData<String>()

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId.value = tvShowId
    }

    var otherTvShows: LiveData<Resource<TvShowWithOtherTvShows>> = Transformations.switchMap(tvShowId) { mTvShowId ->
        movieShowRepository.getDetailTvShow(mTvShowId)
    }

    fun setFavorite() {
        val otherTvShowResource = otherTvShows.value
        if (otherTvShowResource != null) {
            val otherTvShows = otherTvShowResource.data
            if (otherTvShows != null) {
                val tvShowEntity = otherTvShows.mTvShows
                val newState = !tvShowEntity.favorited
                movieShowRepository.setTvShowFavorite(tvShowEntity, newState)
            }
        }
    }
}