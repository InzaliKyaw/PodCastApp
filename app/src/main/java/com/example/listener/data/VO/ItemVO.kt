package com.example.listener.data.VO

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ItemVO(

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("type")
    val type: String,

    @SerializedName("notes")
    val notes: String,

    @SerializedName("added_at_ms")
    val addedAtMs: Long,

    @SerializedName("data")
    val data: DataVO?

)