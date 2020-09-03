package com.example.listener.data.VO

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class PodcastVO(

    @SerializedName("id")
    val id:String,

    @SerializedName("title")
    val title:String,

    @SerializedName("publisher")
    val publisher:String,

    @SerializedName("image")
    val image:String,

    @SerializedName("thumbnail")
    val thumbnail:String,

    @SerializedName("listennotes_url")
    val listennotesUrl:String
    )