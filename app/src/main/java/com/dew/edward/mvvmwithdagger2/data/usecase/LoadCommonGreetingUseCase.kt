package com.dew.edward.mvvmwithdagger2.data.usecase

import com.dew.edward.mvvmwithdagger2.data.repository.CommonGreetingRepository
import io.reactivex.Single
import javax.inject.Inject


/**
 * Created by Edward on 7/15/2018.
 */
class LoadCommonGreetingUseCase(val greetingRepository: CommonGreetingRepository) : LoadGreetingUseCase {

    override fun execute(): Single<String> = greetingRepository.getGreeting()

}