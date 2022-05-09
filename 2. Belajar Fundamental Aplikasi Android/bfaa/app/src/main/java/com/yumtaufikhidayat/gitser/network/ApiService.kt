package com.yumtaufikhidayat.gitser.network

import com.yumtaufikhidayat.gitser.data.response.search.Search
import com.yumtaufikhidayat.gitser.data.response.search.SearchResponse
import com.yumtaufikhidayat.gitser.network.UrlEndpoint.ALL_USERS
import com.yumtaufikhidayat.gitser.network.UrlEndpoint.GITHUB_AUTH_TOKEN
import com.yumtaufikhidayat.gitser.network.UrlEndpoint.SEARCH_USERS
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers(GITHUB_AUTH_TOKEN)
    @GET(ALL_USERS)
    fun getAllUsers(): Call<ArrayList<Search>>

    @Headers(GITHUB_AUTH_TOKEN)
    @GET(SEARCH_USERS)
    fun searchUser(
        @Query("q") query: String
    ): Call<SearchResponse>
}