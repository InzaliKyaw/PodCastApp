package com.example.listener.data.VO

import androidx.room.*
import com.example.listener.typeconverter.GenresIdTypeConverter
import com.google.gson.annotations.SerializedName

@Entity
@TypeConverters(GenresIdTypeConverter::class)
data class Podcast(

    @PrimaryKey
    @SerializedName("id")
    val id: String,

    @SerializedName("country")
    val country: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("earliest_pub_date_ms")
    val earliestPubDatems: Long,

    @SerializedName("email")
    val email: String,

    @SerializedName("explicit_content")
    val explicitContent: Boolean,

    @SerializedName("extraVO")
    val extraVO: ExtraVO,

    @SerializedName("genre_ids")
    val genreIds: List<Int>?,


    @SerializedName("image")
    val image: String,

    @SerializedName("is_claimed")
    val isClaimed: Boolean,

    @SerializedName("itunes_id")
    val itunesId: Int,

    @SerializedName("language")
    val language: String,

    @SerializedName("latest_pub_date_ms")
    val latestPubDateMs: Long,

    @SerializedName("listennotes_url")
    val listennotesUrl: String,

    @SerializedName("looking_forVO")
    val lookingForVO: LookingForVO,

    @SerializedName("publisher")
    val publisher: String,

    @SerializedName("rss")
    val rss: String,

    @SerializedName("thumbnail")
    val thumbnail: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("total_episodes")
    val totalEpisodes: Int,

    @SerializedName("type")
    val type: String,

    @SerializedName("website")
    val website: String
)