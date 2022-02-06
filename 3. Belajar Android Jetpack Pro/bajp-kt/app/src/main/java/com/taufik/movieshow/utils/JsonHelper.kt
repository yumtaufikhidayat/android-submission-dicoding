package com.taufik.movieshow.utils

import android.content.Context
import com.taufik.movieshow.data.source.remote.response.MovieResponse
import com.taufik.movieshow.data.source.remote.response.OtherMoviesResponse
import com.taufik.movieshow.data.source.remote.response.OtherTvShowsResponse
import com.taufik.movieshow.data.source.remote.response.TvShowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponse.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val results = listArray.getJSONObject(i)

                val imageBackdrop = results.getString("imageBackdrop")
                val id = results.getString("id")
                val language = results.getString("language")
                val overview = results.getString("overview")
                val imagePoster = results.getString("imagePoster")
                val releaseDate = results.getString("releaseDate")
                val title = results.getString("title")
                val rating = results.getDouble("rating")
                val homePage = results.getString("homePage")

                val movieResponse = MovieResponse(
                    imageBackdrop,
                    id,
                    language,
                    overview,
                    imagePoster,
                    releaseDate,
                    title,
                    rating,
                    homePage
                )
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadOtherMovies(movieId: String): List<OtherMoviesResponse> {
        val fileName = String.format("OtherMovies_%s.json", movieId)
        val list = ArrayList<OtherMoviesResponse>()
        try {
            val result = parsingFileToString(fileName)
            if (result != null) {
                val responseObject = JSONObject(result)
                val listArray = responseObject.getJSONArray("result")
                for (i in 0 until listArray.length()) {
                    val movie = listArray.getJSONObject(i)

                    val detailMovieId = movie.getString("detailMovieId")
                    val title = movie.getString("title")
                    val imagePoster = movie.getString("imagePoster")
                    val year = movie.getString("year")
                    val rating = movie.getDouble("rating")
                    val position = movie.getString("position")

                    val otherMovieResponse = OtherMoviesResponse(
                        detailMovieId, movieId, title, imagePoster, year, rating, Integer.parseInt(position)
                    )
                    list.add(otherMovieResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvShow(): List<TvShowResponse> {
        val list = ArrayList<TvShowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvShowResponse.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val results = listArray.getJSONObject(i)

                val imageBackdrop = results.getString("imageBackdrop")
                val firstAirDate = results.getString("firstAirDate")
                val id = results.getString("id")
                val title = results.getString("title")
                val language = results.getString("language")
                val overview = results.getString("overview")
                val imagePoster = results.getString("imagePoster")
                val rating = results.getDouble("rating")
                val homePage = results.getString("homePage")

                val movieResponse = TvShowResponse(
                    imageBackdrop,
                    firstAirDate,
                    id,
                    title,
                    language,
                    overview,
                    imagePoster,
                    rating,
                    homePage
                )
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadOtherTvShows(tvShowId: String): List<OtherTvShowsResponse> {
        val fileName = String.format("OtherTvShows_%s.json", tvShowId)
        val list = ArrayList<OtherTvShowsResponse>()
        try {
            val result = parsingFileToString(fileName)
            if (result != null) {
                val responseObject = JSONObject(result)
                val listArray = responseObject.getJSONArray("result")
                for (i in 0 until listArray.length()) {
                    val movie = listArray.getJSONObject(i)

                    val detailTvShowId = movie.getString("detailTvShowId")
                    val title = movie.getString("title")
                    val imagePoster = movie.getString("imagePoster")
                    val year = movie.getString("year")
                    val rating = movie.getDouble("rating")
                    val position = movie.getString("position")

                    val otherTvShowsResponse = OtherTvShowsResponse(
                        detailTvShowId, tvShowId, title, imagePoster, year, rating, Integer.parseInt(position)
                    )
                    list.add(otherTvShowsResponse)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }
}