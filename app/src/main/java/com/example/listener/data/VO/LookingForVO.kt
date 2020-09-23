package com.example.listener.data.VO

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class LookingForVO(

    @SerializedName("cohosts")
    val cohosts: Boolean,

    @SerializedName("cross_promotion")
    val crossPromotion: Boolean,

    @SerializedName("guests")
    val guests: Boolean,

    @SerializedName("sponsors")
    val sponsors: Boolean
)