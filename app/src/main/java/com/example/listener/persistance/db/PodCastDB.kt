package com.example.listener.persistance.db

import android.content.Context
import androidx.room.*
import com.example.listener.data.VO.*
import com.example.listener.network.response.GetMetaDataResponse
import com.example.listener.network.response.GetRandomPodcastResponse
import com.example.listener.persistance.dao.*
import com.example.listener.typeconverter.*

@Database(
    entities = [DataVO::class, ItemVO::class, PodcastVO::class,
        GenreVO::class, GetMetaDataResponse::class, Podcast::class,
        GetRandomPodcastResponse::class, DownloadVO::class],
    version = 10,
    exportSchema = false
)
@TypeConverters(
    ExtraVOTypeConverter::class,
    LookingForTypeConverter::class,
    PodcastTypeConverter::class,
    PodcastVOTypeConverter::class,
    DataVOTypeConverter::class
)
abstract class PodCastDB : RoomDatabase() {
    companion object {
        val DB_NAME = "PodCastDB"
        var dbInstance: PodCastDB? = null
        fun getdbInstance(context: Context): PodCastDB {
            when (dbInstance) {
                null ->
                    dbInstance = Room.databaseBuilder(context, PodCastDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .build()
            }
            val i = dbInstance
            return i!!
        }
    }

    abstract fun itemsDao(): ItemsDao
    abstract fun genersDao(): GenresDao
    abstract fun metaDao(): MetaDao
    abstract fun randomDao(): RandomDao
    abstract fun downloadDao(): DownloadDao
}