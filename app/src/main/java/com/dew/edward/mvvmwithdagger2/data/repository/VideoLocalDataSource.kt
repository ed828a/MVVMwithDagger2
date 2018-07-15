package com.dew.edward.mvvmwithdagger2.data.repository

import com.dew.edward.mvvmwithdagger2.data.database.VideoDao
import com.dew.edward.mvvmwithdagger2.model.VideoModel
import javax.inject.Inject


/**
 * Created by Edward on 7/15/2018.
 */
class VideoLocalDataSource @Inject constructor(val videoDao: VideoDao): VideoDataSource {


    override fun getVideos(): List<VideoModel> {
        return videoDao.getVideosByQuery()
    }

    override fun insert(videos: List<VideoModel>) {
         videoDao.insert(videos)
    }

    override fun deleteAll() {
        videoDao.deleteVideosByQuery()
    }

    // not support yet
    override fun findById(id: Int): VideoModel?  = null
    // not support yet
    override fun deleteById(id: Int) {}
}