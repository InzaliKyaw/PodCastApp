package com.example.listener.data

import com.example.listener.network.response.GetPlaylistResponse
import com.example.listener.util.GET_PLAYLIST_INFO_ITEMS
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface PodcastApi {

    @GET(GET_PLAYLIST_INFO_ITEMS)
    fun getPlaylistInfoItems(@Path ("id")playlistid:String,@Header("X-ListenAPI-Key")token:String):Observable<GetPlaylistResponse>

}