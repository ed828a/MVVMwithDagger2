package com.dew.edward.mvvmwithdagger2.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey


/**
 * Created by Edward on 7/15/2018.
 */
@Entity(tableName = "videos", indices = [(Index(value = ["video_id"], unique = true))])
data class VideoModel(var title: String = "",
                      var date: String = "",
                      var thumbnail: String = "",
                      @PrimaryKey
                      @ColumnInfo(name = "video_id")
                      var videoId: String = "",
                      var relatedToVideoId: String = "",
        // indexResponse: to be consistent with changing backend order
                      var indexResponse: Int = -1)