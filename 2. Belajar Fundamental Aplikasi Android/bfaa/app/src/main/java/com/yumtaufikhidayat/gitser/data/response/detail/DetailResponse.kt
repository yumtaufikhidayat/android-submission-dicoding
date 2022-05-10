package com.yumtaufikhidayat.gitser.data.response.detail

import com.google.gson.annotations.SerializedName

data class DetailResponse(

    @SerializedName("login")
    val login: String?,
    
    @SerializedName("avatar_url")
    val avatarUrl: String,
    
    @SerializedName("html_url")
    val htmlUrl: String,
    
    @SerializedName("name")
    val name: String?,
    
    @SerializedName("company")
    val company: String?,
    
    @SerializedName("blog")
    val blog: String,
    
    @SerializedName("location")
    val location: String?,
    
    @SerializedName("public_repos")
    var publicRepos: Int,
    
    @SerializedName("followers")
    var followers: Int,
    
    @SerializedName("following")
    var following: Int
)
