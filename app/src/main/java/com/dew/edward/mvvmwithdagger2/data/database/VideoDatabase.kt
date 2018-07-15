package com.dew.edward.mvvmwithdagger2.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.dew.edward.mvvmwithdagger2.model.VideoModel


/**
 * Created by Edward on 7/15/2018.
 */
@Database(
        entities = [(VideoModel::class)],
        version = 1,
        exportSchema = false
)
abstract class YoutubeDb: RoomDatabase() {
    abstract fun videoDao(): VideoDao

    companion object {
        fun getVideoDao(context: Context, useInMemory: Boolean): VideoDao {
            val dbBuilder = if (useInMemory) {
                Room.inMemoryDatabaseBuilder(context, YoutubeDb::class.java)
            } else {
                Room.databaseBuilder(context, YoutubeDb::class.java, "videos.db")
            }

            return dbBuilder
                    .fallbackToDestructiveMigration()  // because db is cache, deleting old data is fine
                    .build()
                    .videoDao()
        }
    }
}