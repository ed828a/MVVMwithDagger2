package com.dew.edward.mvvmwithdagger2.di

import com.dew.edward.mvvmwithdagger2.App
import com.dew.edward.mvvmwithdagger2.di.AppModule
import com.dew.edward.mvvmwithdagger2.di.BuildersModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


/**
 * Created by Edward on 7/15/2018.
 */
@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    BuildersModule::class,
    RoomModule::class])
interface AppComponent {
    fun inject(app: App)
}