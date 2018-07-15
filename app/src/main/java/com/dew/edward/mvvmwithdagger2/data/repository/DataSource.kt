package com.dew.edward.mvvmwithdagger2.data.repository

import com.dew.edward.mvvmwithdagger2.model.VideoModel


/**
 * Created by Edward on 7/15/2018.
 */
interface VideoDataSource {

    fun findById(id: Int): VideoModel?

    fun getVideos(): List<VideoModel>

    fun insert(videos: List<VideoModel>)

    fun deleteById(id: Int)

    fun deleteAll()

}