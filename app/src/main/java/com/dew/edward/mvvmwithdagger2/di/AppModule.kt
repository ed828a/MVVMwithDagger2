package com.dew.edward.mvvmwithdagger2.di

import android.app.Application
import com.dew.edward.mvvmwithdagger2.data.repository.CommonGreetingRepository
import com.dew.edward.mvvmwithdagger2.data.repository.LobbyGreetingRepository
import com.dew.edward.mvvmwithdagger2.data.usecase.LoadCommonGreetingUseCase
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
    fun provideLobbyGreetingRepository() = LobbyGreetingRepository()

    @Singleton
    @Provides
    fun provideCommonGreetingService() = CommonGreetingRepository()

    private val greetingRepository =  provideCommonGreetingService()

    @Provides
    fun provideLoadCommonGreetingUseCase() = LoadCommonGreetingUseCase(greetingRepository)
}