package com.example.listener.data.model

import androidx.lifecycle.LiveData
import com.example.listener.data.VO.DownloadVO
import com.example.listener.data.VO.GenreVO
import com.example.listener.network.response.GetMetaDataResponse
import com.example.listener.data.VO.ItemVO
import com.example.listener.network.response.GetRandomPodcastResponse

interface PodCastModel {
    fun getPlaylistInfoandItems(playlistId: String): LiveData<List<ItemVO>>

    fun getGenres(): LiveData<List<GenreVO>>

    fun getMetadata(metaId: String): LiveData<GetMetaDataResponse>

    fun getRandomPodcast(): LiveData<GetRandomPodcastResponse>

    fun saveDownloadPodcastToDB(downloadVO: DownloadVO): Unit

    fun getDownloadPodcastFromDB(): LiveData<List<DownloadVO>>

}