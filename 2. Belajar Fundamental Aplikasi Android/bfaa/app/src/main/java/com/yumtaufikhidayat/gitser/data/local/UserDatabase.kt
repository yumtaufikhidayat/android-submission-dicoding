package com.yumtaufikhidayat.gitser.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yumtaufikhidayat.gitser.utils.Common.DB_NAME
import com.yumtaufikhidayat.gitser.utils.Common.DB_VERSION

@Database(entities = [FavoriteEntity::class], version = DB_VERSION)
abstract class UserDatabase: RoomDatabase() {
    companion object {
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase? {
            if (INSTANCE == null) {
                synchronized(UserDatabase::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        DB_NAME
                    ).fallbackToDestructiveMigration().build()
                }
            }

            return INSTANCE
        }
    }

    abstract fun favoriteUserDao(): FavoriteDao
}