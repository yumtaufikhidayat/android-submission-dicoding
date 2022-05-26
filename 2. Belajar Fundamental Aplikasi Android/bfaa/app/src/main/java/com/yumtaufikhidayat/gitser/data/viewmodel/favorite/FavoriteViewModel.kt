package com.yumtaufikhidayat.gitser.data.viewmodel.favorite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.yumtaufikhidayat.gitser.data.local.FavoriteDao
import com.yumtaufikhidayat.gitser.data.local.FavoriteEntity
import com.yumtaufikhidayat.gitser.data.local.UserDatabase

class FavoriteViewModel(application: Application): AndroidViewModel(application) {

    private var userDao: FavoriteDao?
    private var userDb: UserDatabase? = UserDatabase.getDatabase(application)

    init {
        userDao = userDb?.favoriteUserDao()
    }

    fun getFavoriteUser(): LiveData<List<FavoriteEntity>>? = userDao?.getFavoriteUser()
}