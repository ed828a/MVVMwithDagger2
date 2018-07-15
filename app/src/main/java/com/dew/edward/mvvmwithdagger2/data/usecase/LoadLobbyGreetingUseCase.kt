package com.dew.edward.mvvmwithdagger2.data.usecase

import com.dew.edward.mvvmwithdagger2.data.repository.LobbyGreetingRepository
import io.reactivex.Single
import javax.inject.Inject


/**
 * Created by Edward on 7/15/2018.
 */
class LoadLobbyGreetingUseCase @Inject constructor(val greetingRepository: LobbyGreetingRepository)
    : LoadGreetingUseCase {
    override fun execute(): Single<String> = greetingRepository.getGreeting()
}