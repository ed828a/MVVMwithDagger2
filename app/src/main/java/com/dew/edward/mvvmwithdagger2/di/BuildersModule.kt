package com.dew.edward.mvvmwithdagger2.di

import com.dew.edward.mvvmwithdagger2.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by Edward on 7/15/2018.
 */

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [LobbyModule::class])
    abstract fun bindMainActivity(): MainActivity
}