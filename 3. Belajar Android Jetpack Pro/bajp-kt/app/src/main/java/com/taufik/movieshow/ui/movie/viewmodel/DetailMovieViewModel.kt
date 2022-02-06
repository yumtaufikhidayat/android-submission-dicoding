package com.taufik.movieshow.ui.movie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.taufik.movieshow.data.MovieShowRepository
import com.taufik.movieshow.data.source.local.entity.MovieWithOtherMovies
import com.taufik.movieshow.vo.Resource

class DetailMovieViewModel(private val movieShowRepository: MovieShowRepository) : ViewModel() {

    private var movieId = MutableLiveData<String>()

    fun setSelectedMovie(movieId: String){
        this.movieId.value = movieId
    }

    var otherMovies: LiveData<Resource<MovieWithOtherMovies>> = Transformations.switchMap(movieId) { mMovieId ->
        movieShowRepository.getDetailMovie(mMovieId)
    }

    fun setFavorite() {
        val otherMoviesResource = otherMovies.value
        if (otherMoviesResource != null) {
            val otherMovies = otherMoviesResource.data
            if (otherMovies != null) {
                val movieEntity = otherMovies.mMovie
                val newState = !movieEntity.favorited
                movieShowRepository.setMovieFavorite(movieEntity, newState)
            }
        }
    }
}