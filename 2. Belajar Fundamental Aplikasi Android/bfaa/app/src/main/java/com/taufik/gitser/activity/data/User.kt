package com.taufik.gitser.activity.data

data class User(
    var profileImage: String = "",
    var username: String = "",
    var profileName: String = "",
    var following: Int = 0,
    var followers: Int = 0,
    var repositories: Int = 0,
    var location: String = "",
    var office: String = ""
)