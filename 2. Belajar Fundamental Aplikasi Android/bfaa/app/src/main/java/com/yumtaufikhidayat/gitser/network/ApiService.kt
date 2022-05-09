package com.yumtaufikhidayat.gitser.network

import com.yumtaufikhidayat.gitser.data.response.detail.DetailResponse
import com.yumtaufikhidayat.gitser.data.response.detail.RepositoryResponse
import com.yumtaufikhidayat.gitser.data.response.search.Search
import com.yumtaufikhidayat.gitser.data.response.search.SearchResponse
import com.yumtaufikhidayat.gitser.network.UrlEndpoint.ALL_USERS
import com.yumtaufikhidayat.gitser.network.UrlEndpoint.DETAIL_PROFILE_URL
import com.yumtaufikhidayat.gitser.network.UrlEndpoint.FOLLOWERS_URL
import com.yumtaufikhidayat.gitser.network.UrlEndpoint.FOLLOWING_URL
import com.yumtaufikhidayat.gitser.network.UrlEndpoint.GITHUB_AUTH_TOKEN
import com.yumtaufikhidayat.gitser.network.UrlEndpoint.REPOSITORY_URL
import com.yumtaufikhidayat.gitser.network.UrlEndpoint.SEARCH_USERS
import com.yumtaufikhidayat.gitser.network.UrlEndpoint.USERNAME
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
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

    @Headers(GITHUB_AUTH_TOKEN)
    @GET(DETAIL_PROFILE_URL)
    fun getDetailUser(
        @Path(USERNAME) username: String
    ): Call<DetailResponse>

    @Headers(GITHUB_AUTH_TOKEN)
    @GET(FOLLOWING_URL)
    fun getFollowingUsers(
        @Path(USERNAME) username: String
    ): Call<ArrayList<Search>>

    @Headers(GITHUB_AUTH_TOKEN)
    @GET(FOLLOWERS_URL)
    fun getFollowerUsers(
        @Path(USERNAME) username: String
    ): Call<ArrayList<Search>>

    @Headers(GITHUB_AUTH_TOKEN)
    @GET(REPOSITORY_URL)
    fun getRepositories(
        @Path(USERNAME) username: String
    ): Call<ArrayList<RepositoryResponse>>
}