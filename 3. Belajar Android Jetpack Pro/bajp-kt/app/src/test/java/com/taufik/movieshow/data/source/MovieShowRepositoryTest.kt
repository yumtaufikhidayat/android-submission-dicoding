package com.taufik.movieshow.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.taufik.movieshow.data.FakeMovieShowRepository
import com.taufik.movieshow.data.source.local.LocalDataSource
import com.taufik.movieshow.data.source.local.entity.MovieEntity
import com.taufik.movieshow.data.source.local.entity.OtherMoviesEntity
import com.taufik.movieshow.data.source.local.entity.OtherTvShowsEntity
import com.taufik.movieshow.data.source.local.entity.TvShowEntity
import com.taufik.movieshow.data.source.remote.RemoteDataSource
import com.taufik.movieshow.utils.AppExecutors
import com.taufik.movieshow.utils.DataDummy
import com.taufik.movieshow.utils.LiveDataTestUtil
import com.taufik.movieshow.utils.PagedListUtil
import com.taufik.movieshow.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class MovieShowRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)
    private val movieShowRepository = FakeMovieShowRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteMovieNowPlaying()
    private val movieId = movieResponses[0].id
    private val otherMovieResponses = DataDummy.generateRemoteMovieOtherMovies(movieId)
    private val otherMovieId = otherMovieResponses[0].detailMovieId
    private val tvShowResponse = DataDummy.generateRemoteTvShowsAiringToday()
    private val tvShowId = tvShowResponse[0].id
    private val otherTvShowResponses = DataDummy.generateRemoteTvShowOtherTvShows(tvShowId)
    private val otherTvShowId = otherTvShowResponses[0].detailTvShowId

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovies()).thenReturn(dataSourceFactory)
        movieShowRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateMovieNowPlaying()))
        verify(local).getMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummyOtherMovies = MutableLiveData<List<OtherMoviesEntity>>()
        dummyOtherMovies.value = DataDummy.generateDummyMovieOtherMovies(otherMovieId)
        `when`(local.getAllOtherMoviesByMovie(otherMovieId)).thenReturn(dummyOtherMovies)

        val movieEntities = LiveDataTestUtil.getValue(movieShowRepository.getAllOtherMoviesByMovie(otherMovieId))
        verify(local).getAllOtherMoviesByMovie(otherMovieId)
        assertNotNull(movieEntities.data)
        assertEquals(otherMovieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        movieShowRepository.getFavoritedMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateMovieNowPlaying()))
        verify(local).getFavoriteMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShows()).thenReturn(dataSourceFactory)
        movieShowRepository.getAllTvShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateTvShowsAiringToday()))
        verify(local).getTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailTvShow() {
        val dummyOtherTvShows = MutableLiveData<List<OtherTvShowsEntity>>()
        dummyOtherTvShows.value = DataDummy.generateDummyTvShowOtherTvShows(otherTvShowId)
        `when`(local.getAllOtherTvShowsByTvShow(otherTvShowId)).thenReturn(dummyOtherTvShows)

        val tvShowEntities = LiveDataTestUtil.getValue(movieShowRepository.getAllOtherTvShowsByTvShow(otherTvShowId))
        verify(local).getAllOtherTvShowsByTvShow(otherTvShowId)
        assertNotNull(tvShowEntities.data)
        assertEquals(otherTvShowResponses.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoriteTvShows()).thenReturn(dataSourceFactory)
        movieShowRepository.getFavoritedTvShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateTvShowsAiringToday()))
        verify(local).getFavoriteTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }
}