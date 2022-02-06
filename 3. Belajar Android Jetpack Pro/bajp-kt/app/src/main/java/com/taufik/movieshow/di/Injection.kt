package com.taufik.movieshow.di

import android.content.Context
import com.taufik.movieshow.data.MovieShowRepository
import com.taufik.movieshow.data.source.local.LocalDataSource
import com.taufik.movieshow.data.source.local.room.MovieShowDatabase
import com.taufik.movieshow.data.source.remote.RemoteDataSource
import com.taufik.movieshow.utils.AppExecutors
import com.taufik.movieshow.utils.JsonHelper

object Injection {
    fun provideRepository(context: Context): MovieShowRepository {
        val database = MovieShowDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieShowDao())
        val appExecutors = AppExecutors()
        return MovieShowRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}