package com.yumtaufikhidayat.gitser.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yumtaufikhidayat.gitser.utils.Common.TABLE_NAME
import java.io.Serializable

@Entity(tableName = TABLE_NAME)
data class FavoriteEntity (
    @PrimaryKey
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val type: String
): Serializable