package com.dew.edward.mvvmwithdagger2.di

import android.app.Application
import com.dew.edward.mvvmwithdagger2.data.repository.CommonGreetingRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Edward on 7/15/2018.
 */

@Module
class AppModule {

    @Provides
    fun provideContext(application: Application) = application.applicationContext


    @Singleton
    @Provides
    fun provideCommonHelloService() = CommonGreetingRepository()
}