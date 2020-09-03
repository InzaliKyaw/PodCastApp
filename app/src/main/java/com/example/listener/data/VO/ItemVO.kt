package com.example.listener.data.VO

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class ItemVO(

    @SerializedName("id")
    val id:Int,

    @SerializedName("type")
    val type:String,

    @SerializedName("notes")
    val notes:String,

    @SerializedName("added_at_ms")
    val addedAtMs:Int,

    @SerializedName("data")
    val data:DataVO


)