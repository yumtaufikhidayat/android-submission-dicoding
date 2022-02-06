package com.taufik.movieshow.ui.movie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.taufik.movieshow.data.MovieShowRepository
import com.taufik.movieshow.data.source.local.entity.MovieEntity
import com.taufik.movieshow.vo.Resource

class MovieViewModel(private val movieShowRepository: MovieShowRepository) : ViewModel() {

    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = movieShowRepository.getAllMovies()
}