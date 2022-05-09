package com.yumtaufikhidayat.gitser.network

import com.yumtaufikhidayat.gitser.BuildConfig

object UrlEndpoint {
    const val BASE_URL = "https://api.github.com/"
    const val SEARCH_USERS = "search/users"
    const val DETAIL_PROFILE_URL = "users/{username}"
    const val FOLLOWERS_URL = "users/{username}/followers"
    const val FOLLOWING_URL = "users/{username}/following"
    const val REPOSITORY_URL = "users/{username}/repos"
    const val ALL_USERS = "users"
    const val GITHUB_AUTH_TOKEN = "Authorization: token ${BuildConfig.GITHUB_TOKEN_PAT}"
}