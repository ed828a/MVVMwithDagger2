package com.dew.edward.mvvmwithdagger2.data.database

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.dew.edward.mvvmwithdagger2.model.VideoModel


/**
 * Created by Edward on 7/15/2018.
 */

@Dao
interface VideoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(videos: List<VideoModel>)

    @Query("SELECT * FROM videos ORDER BY indexResponse ASC")
//    fun getVideosByQuery(): DataSource.Factory<Int, VideoModel>
    fun getVideosByQuery(): List<VideoModel>

    @Query("DELETE FROM videos")
    fun deleteVideosByQuery()

    @Query("SELECT * FROM videos WHERE relatedToVideoId = :relatedToVideoId ORDER BY indexResponse ASC")
    fun getVideosByRelatedToVideoId(relatedToVideoId: String): DataSource.Factory<Int, VideoModel>

    @Query("DELETE FROM videos WHERE relatedToVideoId = :relatedToVideoId")
    fun deleteVideosByRelatedToVideoId(relatedToVideoId: String)

    @Query("SELECT MAX(indexResponse) + 1 FROM videos")
    fun getNextIndexInVideo(): Int

    @Query("SELECT * FROM videos ORDER BY indexResponse ASC")
    fun dumpAll(): List<VideoModel>


}