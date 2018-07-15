package com.dew.edward.mvvmwithdagger2.lobby

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.dew.edward.mvvmwithdagger2.common.domain.interactors.LoadCommonGreetingUseCase
import com.dew.edward.mvvmwithdagger2.common.domain.interactors.LoadGreetingUseCase
import com.dew.edward.mvvmwithdagger2.common.viewmodel.Response
import com.dew.edward.mvvmwithdagger2.rx.SchedulersFacade
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by Edward on 7/15/2018.
 */
class LobbyViewModel(
        val loadCommonGreetingUseCase: LoadCommonGreetingUseCase,
        val loadLobbyGreetingUseCase: LoadLobbyGreetingUseCase,
        val schedulersFacade: SchedulersFacade): ViewModel() {

    val disposables: CompositeDisposable = CompositeDisposable()

    val response: MutableLiveData<Response> = MutableLiveData()

    override fun onCleared() {
        disposables.clear()
    }

    private fun loadGreeting(loadGreetingUseCase: LoadGreetingUseCase){
        disposables.add(loadGreetingUseCase.execute()
                .subscribeOn(schedulersFacade.io())
                .observeOn(schedulersFacade.ui())
                .doOnSubscribe {
                    response.value = Response.loading()
                }
                .subscribe({greeting -> response.value = Response.success(greeting)},
                        {throwable -> response.value = Response.error(throwable)})
        )
    }

    fun loadCommmonGreeting() = loadGreeting(loadCommonGreetingUseCase)
    fun loadLobbyGreeting() = loadGreeting(loadLobbyGreetingUseCase)
    fun response(): MutableLiveData<Response> = response
}