package com.example.listener.network.response

import com.example.listener.data.VO.ItemVO

data class GetPlaylistResponse(
    val type:String,
    val items:List<ItemVO> ?= arrayListOf()
)