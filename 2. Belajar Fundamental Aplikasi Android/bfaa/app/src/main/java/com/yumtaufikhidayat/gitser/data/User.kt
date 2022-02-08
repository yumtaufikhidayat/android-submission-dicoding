package com.yumtaufikhidayat.gitser.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var profileImage: String = "",
    var username: String = "",
    var profileName: String = "",
    var following: Int = 0,
    var followers: Int = 0,
    var repositories: Int = 0,
    var location: String = "",
    var office: String = "",
    var profileLink: String = ""
): Parcelable