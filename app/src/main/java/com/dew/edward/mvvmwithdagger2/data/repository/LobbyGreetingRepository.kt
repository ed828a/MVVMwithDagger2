package com.dew.edward.mvvmwithdagger2.data.repository

import io.reactivex.Single


/**
 * Created by Edward on 7/15/2018.
 */
class LobbyGreetingRepository {
    fun getGreeting() = Single.just("Hello from LobbyGreetingRepository")
}