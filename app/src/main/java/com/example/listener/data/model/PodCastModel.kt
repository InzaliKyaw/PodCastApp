package com.example.listener.data.model

import androidx.lifecycle.LiveData
import com.example.listener.data.VO.ItemVO

interface PodCastModel {
    fun getPlaylistInfoandItems(playlistId:String):LiveData<List<ItemVO>>
}