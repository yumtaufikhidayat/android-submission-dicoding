package com.taufik.movieshow.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.taufik.movieshow.data.source.local.LocalDataSource
import com.taufik.movieshow.data.source.local.entity.*
import com.taufik.movieshow.data.source.remote.ApiResponse
import com.taufik.movieshow.data.source.remote.RemoteDataSource
import com.taufik.movieshow.data.source.remote.response.MovieResponse
import com.taufik.movieshow.data.source.remote.response.OtherMoviesResponse
import com.taufik.movieshow.data.source.remote.response.OtherTvShowsResponse
import com.taufik.movieshow.data.source.remote.response.TvShowResponse
import com.taufik.movieshow.utils.AppExecutors
import com.taufik.movieshow.vo.Resource

class MovieShowRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : MovieShowDataSource {

    companion object {
        @Volatile
        private var instance: MovieShowRepository? = null

        fun getInstance(
            remoteDataSource: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): MovieShowRepository =
            instance ?: synchronized(this) {
                instance ?: MovieShowRepository(remoteDataSource, localData, appExecutors).apply {
                    instance = this
                }
            }
    }

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.id,
                        response.imageBackdrop,
                        response.language,
                        response.overview,
                        response.imagePoster,
                        response.releaseDate,
                        response.title,
                        response.rating,
                        response.homePage,
                        false
                    )
                    movieList.add(movie)
                }

                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(movieId: String): LiveData<Resource<MovieWithOtherMovies>> {
        return object : NetworkBoundResource<MovieWithOtherMovies, List<OtherMoviesResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<MovieWithOtherMovies> =
                localDataSource.getDetailMovie(movieId)

            override fun shouldFetch(data: MovieWithOtherMovies?): Boolean =
                data?.mOtherMovies == null || data.mOtherMovies.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<OtherMoviesResponse>>> =
                remoteDataSource.getOtherMovies(movieId)

            override fun saveCallResult(data: List<OtherMoviesResponse>) {
                val otherMoviesList = ArrayList<OtherMoviesEntity>()
                for (response in data) {
                    val movie = OtherMoviesEntity(
                        response.detailMovieId,
                        response.movieId,
                        response.title,
                        response.imagePoster,
                        response.year,
                        response.rating,
                        response.position,
                        false
                    )
                    otherMoviesList.add(movie)
                }
                localDataSource.insertOtherMovies(otherMoviesList)
            }
        }.asLiveData()
    }

    override fun getFavoritedMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun getAllOtherMoviesByMovie(movieId: String): LiveData<Resource<List<OtherMoviesEntity>>> {
        return object : NetworkBoundResource<List<OtherMoviesEntity>, List<OtherMoviesResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<List<OtherMoviesEntity>> =
                localDataSource.getAllOtherMoviesByMovie(movieId)

            override fun shouldFetch(data: List<OtherMoviesEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<OtherMoviesResponse>>> =
                remoteDataSource.getOtherMovies(movieId)

            override fun saveCallResult(data: List<OtherMoviesResponse>) {
                val otherMoviesList = ArrayList<OtherMoviesEntity>()
                for (response in data) {
                    val movie = OtherMoviesEntity(
                        response.detailMovieId,
                        response.movieId,
                        response.title,
                        response.imagePoster,
                        response.year,
                        response.rating,
                        response.position,
                        false
                    )
                    otherMoviesList.add(movie)
                }

                localDataSource.insertOtherMovies(otherMoviesList)
            }

        }.asLiveData()
    }

    override fun setMovieFavorite(movie: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state)}
    }

    override fun getAllTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                remoteDataSource.getAllTvShows()

            override fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvShow = TvShowEntity(
                        response.id,
                        response.imageBackdrop,
                        response.firstAirDate,
                        response.title,
                        response.language,
                        response.overview,
                        response.imagePoster,
                        response.rating,
                        response.homePage,
                        false
                    )
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShows(tvShowList)
            }
        }.asLiveData()
    }

    override fun getDetailTvShow(tvShowId: String): LiveData<Resource<TvShowWithOtherTvShows>> {
        return object : NetworkBoundResource<TvShowWithOtherTvShows, List<OtherTvShowsResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<TvShowWithOtherTvShows> =
                localDataSource.getDetailTvShow(tvShowId)

            override fun shouldFetch(data: TvShowWithOtherTvShows?): Boolean =
                data?.mOtherTvShows == null || data.mOtherTvShows.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<OtherTvShowsResponse>>> =
                remoteDataSource.getOtherTvShows(tvShowId)

            override fun saveCallResult(data: List<OtherTvShowsResponse>) {
                val otherTvShowsList = ArrayList<OtherTvShowsEntity>()
                for (response in data) {
                    val tvShow = OtherTvShowsEntity(
                        response.detailTvShowId,
                        response.tvShowId,
                        response.title,
                        response.imagePoster,
                        response.year,
                        response.rating,
                        response.position,
                        false
                    )
                    otherTvShowsList.add(tvShow)
                }
                localDataSource.insertOtherTvShows(otherTvShowsList)
            }
        }.asLiveData()
    }

    override fun getFavoritedTvShows(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShows(), config).build()
    }

    override fun getAllOtherTvShowsByTvShow(tvShowId: String): LiveData<Resource<List<OtherTvShowsEntity>>> {
        return object : NetworkBoundResource<List<OtherTvShowsEntity>, List<OtherTvShowsResponse>>(appExecutors){
            override fun loadFromDB(): LiveData<List<OtherTvShowsEntity>> =
                localDataSource.getAllOtherTvShowsByTvShow(tvShowId)

            override fun shouldFetch(data: List<OtherTvShowsEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<OtherTvShowsResponse>>> =
                remoteDataSource.getOtherTvShows(tvShowId)

            override fun saveCallResult(data: List<OtherTvShowsResponse>) {
                val otherTvShowsList = ArrayList<OtherTvShowsEntity>()
                for (response in data) {
                    val tvShow = OtherTvShowsEntity(
                        response.detailTvShowId,
                        response.tvShowId,
                        response.title,
                        response.imagePoster,
                        response.year,
                        response.rating,
                        response.position,
                        false
                    )
                    otherTvShowsList.add(tvShow)
                }
            }

        }.asLiveData()
    }

    override fun setTvShowFavorite(tvShow: TvShowEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setTvShowFavorite(tvShow, state) }
    }
}