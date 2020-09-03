package com.example.listener.data.VO

import android.icu.text.CaseMap
import androidx.room.Entity

@Entity
data class DataVO(
    val id:String,

    val title: String,

    val description:String,

    val pubDateMS:Int,

    val audio:String,

    val audioLengthSec:Int,

    val listenNotesUrl:String,

    val image:String,

    val thumbnail:String,

    val maybeAudioInvalid:Boolean,

    val listenNotesEditUrl:String,

    val explicitContent:Boolean,

    val link:String,

    val podcast:PodcastVO
)