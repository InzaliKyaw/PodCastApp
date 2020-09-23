package com.example.listener.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenresIdTypeConverter {

    @TypeConverter
    fun toString(genresId: List<Int>): String {
        return Gson().toJson(genresId)
    }

    @TypeConverter
    fun toGenresId(genresIdListJsonString: String): List<Int> {
        val genresIdType = object : TypeToken<List<Int>>() {}.type
        return Gson().fromJson(genresIdListJsonString, genresIdType)
    }
}