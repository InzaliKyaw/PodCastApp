package com.example.listener.network.response

import com.example.listener.data.VO.ItemVO
import com.google.gson.annotations.SerializedName

data class GetPlaylistResponse(

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("thumbnail")
    val thumbnail: String,

    @SerializedName("listennotes_url")
    val listennotesUrl: String,

    @SerializedName("visibility")
    val visibility: String,

    @SerializedName("last_timestamp_ms")
    val lastTimeStampMS: Long,

    @SerializedName("total")
    val total: Int,

    @SerializedName("type")
    val type: String,

    @SerializedName("items")
    val items: List<ItemVO>? = arrayListOf()
)