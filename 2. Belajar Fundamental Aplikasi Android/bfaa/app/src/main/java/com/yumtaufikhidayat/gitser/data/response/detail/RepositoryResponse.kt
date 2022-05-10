package com.yumtaufikhidayat.gitser.data.response.detail

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(

    @SerializedName("description")
    val description: String,

    @SerializedName("html_url")
    val htmlUrl: String,

    @SerializedName("language")
    val language: String?,

    @SerializedName("name")
    val name: String,

    @SerializedName("size")
    val size: Int,

    @SerializedName("visibility")
    val visibility: String
)
