package com.taufik.movieshow.ui.tvshow.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.taufik.movieshow.data.MovieShowRepository
import com.taufik.movieshow.data.source.local.entity.TvShowWithOtherTvShows
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
class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateTvShowsAiringToday()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieShowRepository: MovieShowRepository

    @Mock
    private lateinit var observer: Observer<Resource<TvShowWithOtherTvShows>>

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel(movieShowRepository)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getTvShowWithOtherTvShows() {
        val dummyTvShowWithOtherTvShows = Resource.success(DataDummy.generateDummyTvShowWithOtherTvShows(dummyTvShow, true))
        val tvShow = MutableLiveData<Resource<TvShowWithOtherTvShows>>()
        tvShow.value = dummyTvShowWithOtherTvShows
        `when`(movieShowRepository.getDetailTvShow(tvShowId)).thenReturn(tvShow)
        viewModel.otherTvShows.observeForever(observer)
        verify(observer).onChanged(dummyTvShowWithOtherTvShows)
    }
}