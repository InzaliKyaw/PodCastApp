package com.example.listener.data.VO

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class PodcastVO(

    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("publisher")
    val publisher: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("thumbnail")
    val thumbnail: String,

    @SerializedName("listennotes_url")
    val listennotesUrl: String
)