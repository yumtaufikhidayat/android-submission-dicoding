package com.taufik.movieshow.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.taufik.movieshow.data.source.remote.response.MovieResponse
import com.taufik.movieshow.data.source.remote.response.OtherMoviesResponse
import com.taufik.movieshow.data.source.remote.response.OtherTvShowsResponse
import com.taufik.movieshow.data.source.remote.response.TvShowResponse
import com.taufik.movieshow.utils.EspressoIdlingResource
import com.taufik.movieshow.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2_000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply {
                    instance = this
                }
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<MovieResponse>>>{
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovies())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }

    fun getAllTvShows(): LiveData<ApiResponse<List<TvShowResponse>>>{
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        handler.postDelayed({
            resultTvShow.value = ApiResponse.success(jsonHelper.loadTvShow())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShow
    }

    fun getOtherMovies(movieId: String): LiveData<ApiResponse<List<OtherMoviesResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<OtherMoviesResponse>>>()
        handler.postDelayed({
            resultMovies.value = ApiResponse.success(jsonHelper.loadOtherMovies(movieId))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovies
    }

    fun getOtherTvShows(tvShowId: String): LiveData<ApiResponse<List<OtherTvShowsResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShows = MutableLiveData<ApiResponse<List<OtherTvShowsResponse>>>()
        handler.postDelayed({
            resultTvShows.value = ApiResponse.success(jsonHelper.loadOtherTvShows(tvShowId))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShows
    }
}