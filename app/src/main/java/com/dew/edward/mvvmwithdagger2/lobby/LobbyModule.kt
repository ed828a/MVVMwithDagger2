package com.dew.edward.mvvmwithdagger2.lobby

import com.dew.edward.mvvmwithdagger2.common.domain.interactors.LoadCommonGreetingUseCase
import com.dew.edward.mvvmwithdagger2.rx.SchedulersFacade
import dagger.Module
import dagger.Provides


/**
 * Created by Edward on 7/15/2018.
 */

@Module
class LobbyModule {

    @Provides
    fun provideLobbyGreetingRepository() = LobbyGreetingRepository()


    @Provides
    fun provideLobbyViewModelFactory(
            loadCommonGreetingUseCase: LoadCommonGreetingUseCase,
            loadLobbyGreetingUseCase: LoadLobbyGreetingUseCase,
            schedulersFacade: SchedulersFacade): LobbyViewModelFactory {

        return LobbyViewModelFactory(loadCommonGreetingUseCase, loadLobbyGreetingUseCase, schedulersFacade)
    }
}