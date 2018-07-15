package com.dew.edward.mvvmwithdagger2.data.usecase

import io.reactivex.Single


/**
 * Created by Edward on 7/15/2018.
 */
interface LoadGreetingUseCase {
    fun execute(): Single<String>
}