package com.example.listener.data.VO

import android.icu.text.CaseMap
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.listener.typeconverter.PodcastTypeConverter
import com.google.gson.annotations.SerializedName

@Entity
data class DataVO(

    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("pub_date_ms")
    val pubDateMS: Long,

    @SerializedName("audio")
    val audio: String,

    @SerializedName("audio_length_sec")
    val audioLengthSec: Int,

    @SerializedName("listennotes_url")
    val listenNotesUrl: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("thumbnail")
    val thumbnail: String,

    @SerializedName("maybe_audio_invalid")
    val maybeAudioInvalid: Boolean,

    @SerializedName("listennotes_edit_url")
    val listenNotesEditUrl: String,

    @SerializedName("explicit_content")
    val explicitContent: Boolean,

    @SerializedName("link")
    val link: String,

    @SerializedName("podcast")
    val podcast: PodcastVO
)