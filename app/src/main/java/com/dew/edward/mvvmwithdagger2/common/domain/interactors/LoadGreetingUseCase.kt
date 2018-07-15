package com.dew.edward.mvvmwithdagger2.common.domain.interactors

import io.reactivex.Single


/**
 * Created by Edward on 7/15/2018.
 */
interface LoadGreetingUseCase {
    fun execute(): Single<String>
}