package com.yumtaufikhidayat.gitser.network

import com.yumtaufikhidayat.gitser.BuildConfig
import com.yumtaufikhidayat.gitser.data.response.search.Search
import com.yumtaufikhidayat.gitser.network.UrlEndpoint.ALL_USERS
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers("Authorization: token ${BuildConfig.GITHUB_TOKEN_PAT}")
    @GET(ALL_USERS)
    fun getAllUsers(): Call<ArrayList<Search>>
}