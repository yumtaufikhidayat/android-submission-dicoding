package com.taufik.movieshow.ui.tvshow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.taufik.movieshow.data.MovieShowRepository
import com.taufik.movieshow.data.source.local.entity.TvShowEntity
import com.taufik.movieshow.vo.Resource

class TvShowViewModel(private val movieShowRepository: MovieShowRepository) : ViewModel() {

    fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> = movieShowRepository.getAllTvShows()
}