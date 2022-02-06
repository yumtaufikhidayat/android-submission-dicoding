package com.taufik.movieshow.ui.activity

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.taufik.movieshow.data.MovieShowRepository
import com.taufik.movieshow.di.Injection
import com.taufik.movieshow.ui.movie.viewmodel.DetailMovieViewModel
import com.taufik.movieshow.ui.movie.viewmodel.FavoriteMovieViewModel
import com.taufik.movieshow.ui.movie.viewmodel.MovieViewModel
import com.taufik.movieshow.ui.tvshow.viewmodel.DetailTvShowViewModel
import com.taufik.movieshow.ui.tvshow.viewmodel.FavoriteTvShowViewModel
import com.taufik.movieshow.ui.tvshow.viewmodel.TvShowViewModel

class ViewModelFactory private constructor(private val movieShowRepository: MovieShowRepository)
    : ViewModelProvider.NewInstanceFactory(){
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this){
                instance?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(movieShowRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(movieShowRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(movieShowRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                DetailTvShowViewModel(movieShowRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java) -> {
                FavoriteMovieViewModel(movieShowRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteTvShowViewModel::class.java) -> {
                FavoriteTvShowViewModel(movieShowRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}