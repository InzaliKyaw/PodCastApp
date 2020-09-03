package com.example.listener.persistance.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.listener.data.VO.ItemVO

@Dao
interface ItemsDao {

    @androidx.room.Query("SELECT * FROM ItemVO")
    fun getAllItems():LiveData<List<ItemVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllItems(itemlist:List<ItemVO>)


}