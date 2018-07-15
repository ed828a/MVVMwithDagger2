package com.dew.edward.mvvmwithdagger2.common.domain.model

import io.reactivex.Single


/**
 * Created by Edward on 7/15/2018.
 */
class CommonGreetingRepository {
    fun getGreeting() = Single.just("Hello from CommonGreetingRepository")
}