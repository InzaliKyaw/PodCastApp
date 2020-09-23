package com.example.listener.persistance.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.listener.data.VO.GenreVO
import com.example.listener.data.VO.ItemVO

@Dao
interface GenresDao {

    @androidx.room.Query("SELECT * FROM GenreVO")
    fun getAllGenres(): LiveData<List<GenreVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllGenres(itemlist: List<GenreVO>)
}