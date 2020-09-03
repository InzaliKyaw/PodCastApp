package com.example.listener.persistance.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.listener.persistance.dao.ItemsDao

abstract class PodCastDB: RoomDatabase() {
    companion object{
        val DB_NAME = "PodCastDB"
        var dbInstance:PodCastDB ?= null
        fun getdbInstance(context: Context): PodCastDB{
            when(dbInstance){
                null ->
                    dbInstance = Room.databaseBuilder(context,PodCastDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .build()
            }
            val i = dbInstance
            return i!!
        }
    }

    abstract fun itemsDao():ItemsDao
}