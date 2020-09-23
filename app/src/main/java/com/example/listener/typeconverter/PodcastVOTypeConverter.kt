package com.example.listener.typeconverter

import androidx.room.TypeConverter
import com.example.listener.data.VO.PodcastVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PodcastVOTypeConverter {
    @TypeConverter
    fun toString(podcastVO: PodcastVO): String {
        return Gson().toJson(podcastVO)
    }

    @TypeConverter
    fun toPodcastList(podcastListJsonString: String): PodcastVO {
        val podcastType = object : TypeToken<PodcastVO>() {}.type
        return Gson().fromJson(podcastListJsonString, podcastType)
    }
}