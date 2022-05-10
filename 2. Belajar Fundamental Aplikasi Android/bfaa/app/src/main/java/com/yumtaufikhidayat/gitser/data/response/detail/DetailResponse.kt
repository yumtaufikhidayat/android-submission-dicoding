package com.yumtaufikhidayat.gitser.data.response.detail

import com.google.gson.annotations.SerializedName

data class DetailResponse(

    @SerializedName("login")
    val login: String?,
    
    @SerializedName("id")
    var id: Int,
    
    @SerializedName("node_id")
    val nodeId: String,
    
    @SerializedName("avatar_url")
    val avatarUrl: String,
    
    @SerializedName("gravatar_id")
    val gravatarId: String,
    
    @SerializedName("url")
    val url: String,
    
    @SerializedName("html_url")
    val htmlUrl: String,
    
    @SerializedName("followers_url")
    val followersUrl: String,
    
    @SerializedName("following_url")
    val followingUrl: String,
    
    @SerializedName("gists_url")
    val gistsUrl: String,
    
    @SerializedName("starred_url")
    val starredUrl: String,
    
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String,
    
    @SerializedName("organizations_url")
    val organizationsUrl: String,
    
    @SerializedName("repos_url")
    val reposUrl: String,
    
    @SerializedName("events_url")
    val eventsUrl: String,
    
    @SerializedName("received_events_url")
    val receivedEventsUrl: String,
    
    @SerializedName("type")
    val type: String,
    
    @SerializedName("site_admin")
    var siteAdmin: Boolean,
    
    @SerializedName("name")
    val name: String?,
    
    @SerializedName("company")
    val company: String?,
    
    @SerializedName("blog")
    val blog: String,
    
    @SerializedName("location")
    val location: String?,
    
    @SerializedName("bio")
    val bio: String,
    
    @SerializedName("public_repos")
    var publicRepos: Int,
    
    @SerializedName("public_gists")
    var publicGists: Int,
    
    @SerializedName("followers")
    var followers: Int,
    
    @SerializedName("following")
    var following: Int,
    
    @SerializedName("created_at")
    val createdAt: String,
    
    @SerializedName("updated_at")
    val updatedAt: String
)
