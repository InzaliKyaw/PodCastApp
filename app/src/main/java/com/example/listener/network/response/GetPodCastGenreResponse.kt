package com.example.listener.network.response

import com.example.listener.data.VO.GenreVO
import com.google.gson.annotations.SerializedName

data class GetPodCastGenreResponse(

    @SerializedName("genres")
    val genreVOS: List<GenreVO>
)