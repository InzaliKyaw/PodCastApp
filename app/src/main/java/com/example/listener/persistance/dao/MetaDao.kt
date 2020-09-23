package com.example.listener.persistance.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.listener.network.response.GetMetaDataResponse

@Dao
interface MetaDao {

    @androidx.room.Query("SELECT * FROM GetMetaDataResponse")
    fun getAllMetaData(): LiveData<GetMetaDataResponse>

    @Query("SELECT * FROM GetMetaDataResponse WHERE id=:metaId")
    fun getMetaDataWithId(metaId: String): LiveData<GetMetaDataResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllMetaData(metaVO: GetMetaDataResponse)
}