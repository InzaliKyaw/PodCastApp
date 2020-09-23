package com.example.listener.typeconverter

import androidx.room.TypeConverter
import com.example.listener.data.VO.Podcast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PodcastTypeConverter {

    @TypeConverter
    fun toString(podcastVO: Podcast): String {
        return Gson().toJson(podcastVO)
    }

    @TypeConverter
    fun toPodcastList(podcastListJsonString: String): Podcast {
        val podcastType = object : TypeToken<Podcast>() {}.type
        return Gson().fromJson(podcastListJsonString, podcastType)
    }
}