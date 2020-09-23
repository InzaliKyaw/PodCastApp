package com.example.listener.data.VO

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class GenreVO(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("parent_id")
    val parentId: Int
)