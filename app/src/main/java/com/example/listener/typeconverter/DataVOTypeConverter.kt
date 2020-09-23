package com.example.listener.typeconverter

import androidx.room.TypeConverter
import com.example.listener.data.VO.DataVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataVOTypeConverter {

    @TypeConverter
    fun toString(dataVO: DataVO): String {
        return Gson().toJson(dataVO)
    }

    @TypeConverter
    fun toDataVO(dataVOJsonString: String): DataVO {
        val dataVOType = object : TypeToken<DataVO>() {}.type
        return Gson().fromJson(dataVOJsonString, dataVOType)
    }
}