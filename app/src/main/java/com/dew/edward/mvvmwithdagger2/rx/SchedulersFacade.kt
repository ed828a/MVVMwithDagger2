package com.dew.edward.mvvmwithdagger2.rx

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by Edward on 7/15/2018.
 */
/**
 * a custom wrapper class to decouple ViewModel and Schedulers for testing
 */
class SchedulersFacade @Inject constructor(){
    fun io() = Schedulers.io()
    fun computation() = Schedulers.computation()
    fun ui() = AndroidSchedulers.mainThread()
}