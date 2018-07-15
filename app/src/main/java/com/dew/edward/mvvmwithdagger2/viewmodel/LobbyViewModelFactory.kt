package com.dew.edward.mvvmwithdagger2.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.dew.edward.mvvmwithdagger2.data.usecase.LoadCommonGreetingUseCase
import com.dew.edward.mvvmwithdagger2.data.usecase.LoadLobbyGreetingUseCase
import com.dew.edward.mvvmwithdagger2.rx.SchedulersFacade


/**
 * Created by Edward on 7/15/2018.
 */
class LobbyViewModelFactory(
        val loadCommonGreetingUseCase: LoadCommonGreetingUseCase,
        val loadLobbyGreetingUseCase: LoadLobbyGreetingUseCase,
        val schedulersFacade: SchedulersFacade
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LobbyViewModel::class.java)){
            return LobbyViewModel(
                    loadCommonGreetingUseCase,
                    loadLobbyGreetingUseCase,
                    schedulersFacade) as T
        } else {
            throw IllegalArgumentException("Unknow ViewModel Class")
        }
    }
}