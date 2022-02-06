package com.taufik.movieshow.ui.movie.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.taufik.movieshow.data.MovieShowRepository
import com.taufik.movieshow.data.source.local.entity.MovieWithOtherMovies
import com.taufik.movieshow.utils.DataDummy
import com.taufik.movieshow.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateMovieNowPlaying()[0]
    private val movieId = dummyMovie.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieShowRepository: MovieShowRepository

    @Mock
    private lateinit var observer: Observer<Resource<MovieWithOtherMovies>>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(movieShowRepository)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovieWithOtherMovies() {
        val dummyMovieWithOtherMovies = Resource.success(DataDummy.generateDummyMovieWithOtherMovies(dummyMovie, true))
        val movie = MutableLiveData<Resource<MovieWithOtherMovies>>()
        movie.value = dummyMovieWithOtherMovies
        `when`(movieShowRepository.getDetailMovie(movieId)).thenReturn(movie)
        viewModel.otherMovies.observeForever(observer)
        verify(observer).onChanged(dummyMovieWithOtherMovies)
    }
}