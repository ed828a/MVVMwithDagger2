package com.dew.edward.mvvmwithdagger2.common.domain.interactors

import com.dew.edward.mvvmwithdagger2.common.domain.model.CommonGreetingRepository
import io.reactivex.Single
import javax.inject.Inject


/**
 * Created by Edward on 7/15/2018.
 */
class LoadCommonGreetingUseCase @Inject constructor(
        val greetingRepository: CommonGreetingRepository) : LoadGreetingUseCase {

    override fun execute(): Single<String> = greetingRepository.getGreeting()

}