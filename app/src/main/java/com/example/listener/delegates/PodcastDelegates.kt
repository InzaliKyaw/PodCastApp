package com.example.listener.delegates

import com.example.listener.data.VO.ItemVO

interface PodcastDelegates {

    fun onTapPodCast(id: String)
    fun onTapDownloadImage(itemVO: ItemVO)
}