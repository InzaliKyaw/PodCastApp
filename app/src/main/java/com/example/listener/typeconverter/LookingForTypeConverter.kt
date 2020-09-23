package com.example.listener.typeconverter

import androidx.room.TypeConverter
import com.example.listener.data.VO.LookingForVO
import com.example.listener.data.VO.Podcast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LookingForTypeConverter {

    @TypeConverter
    fun toString(lookingForVO: LookingForVO): String {
        return Gson().toJson(lookingForVO)
    }

    @TypeConverter
    fun toLookingForVO(lookingForJsonString: String): LookingForVO {
        val lookingForType = object : TypeToken<LookingForVO>() {}.type
        return Gson().fromJson(lookingForJsonString, lookingForType)
    }
}