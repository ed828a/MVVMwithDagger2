package com.dew.edward.mvvmwithdagger2.di

import android.content.Context
import com.dew.edward.mvvmwithdagger2.data.database.VideoDao
import com.dew.edward.mvvmwithdagger2.data.database.YoutubeDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Edward on 7/15/2018.
 */

@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideVideoDao(context: Context): VideoDao {
        return YoutubeDb.getVideoDao(context, false)
    }
}