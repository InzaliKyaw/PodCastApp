package com.example.listener.persistance.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.listener.network.response.GetMetaDataResponse
import com.example.listener.network.response.GetRandomPodcastResponse

@Dao
interface RandomDao {

    @androidx.room.Query("SELECT * FROM GetRandomPodcastResponse")
    fun getAllRandomPodcast(): LiveData<GetRandomPodcastResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllRandomPodcast(metaVO: GetRandomPodcastResponse)
}