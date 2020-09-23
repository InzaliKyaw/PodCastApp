package com.example.listener.typeconverter

import androidx.room.TypeConverter
import com.example.listener.data.VO.ExtraVO
import com.example.listener.data.VO.Podcast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ExtraVOTypeConverter {

    @TypeConverter
    fun toString(extraVO: ExtraVO): String {
        return Gson().toJson(extraVO)
    }

    @TypeConverter
    fun toExtraVO(extraVOJsonString: String): ExtraVO {
        val extraVOType = object : TypeToken<ExtraVO>() {}.type
        return Gson().fromJson(extraVOJsonString, extraVOType)
    }
}