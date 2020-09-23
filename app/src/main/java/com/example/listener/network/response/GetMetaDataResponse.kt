package com.example.listener.network.response

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.listener.data.VO.Podcast
import com.google.gson.annotations.SerializedName

@Entity
data class GetMetaDataResponse(

    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("audio")
    val audio: String,

    @SerializedName("audio_length_sec")
    val audioLengthSec: Int,

    @SerializedName("description")
    val description: String,

    @SerializedName("explicit_content")
    val explicitContent: Boolean,

    @SerializedName("image")
    val image: String,

    @SerializedName("link")
    val link: String,

    @SerializedName("listennotes_edit_url")
    val listennotesEditUrl: String,

    @SerializedName("listennotes_url")
    val listennotesUrl: String,

    @SerializedName("maybe_audio_invalid")
    val maybeAudioInvalid: Boolean,

    @SerializedName("podcast")
    val podcast: Podcast,

    @SerializedName("pub_date_ms")
    val pubDateMs: Long,

    @SerializedName("thumbnail")
    val thumbnail: String,

    @SerializedName("title")
    val title: String
)