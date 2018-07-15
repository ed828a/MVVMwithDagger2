package com.dew.edward.mvvmwithdagger2.model


/**
 * Created by Edward on 7/15/2018.
 */
class Response(val status: Status, val data: String?, val error: Throwable?) {
    companion object {
        fun loading() = Response(Status.LOADING, null, null)
        fun success(data: String?) = Response(Status.SUCCESS, data, null)
        fun error(error: Throwable?) = Response(Status.ERROR, null, error)
    }
}