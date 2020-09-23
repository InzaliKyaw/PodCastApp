package com.example.listener.persistance.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.listener.data.VO.DownloadVO
import com.example.listener.data.VO.ItemVO

@Dao
interface DownloadDao {
    @androidx.room.Query("SELECT * FROM DownloadVO")
    fun getAllDownloadVO(): LiveData<List<DownloadVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllDownloadVO(itemlist: DownloadVO)
}