package com.example.listener.data

import com.example.listener.network.response.GetMetaDataResponse
import com.example.listener.network.response.GetPlaylistResponse
import com.example.listener.network.response.GetPodCastGenreResponse
import com.example.listener.network.response.GetRandomPodcastResponse
import com.example.listener.util.GET_PLAYLIST_INFO_ITEMS
import com.example.listener.util.GET_PODCAST_GENRES
import com.example.listener.util.GET_PODCAST_METADATA
import com.example.listener.util.GET_RANDOM_PODCAST
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface PodcastApi {

    @GET(GET_PLAYLIST_INFO_ITEMS)
    fun getPlaylistInfoItems(
        @Path("id") playlistid: String,
        @Header("X-ListenAPI-Key") token: String
    ): Observable<GetPlaylistResponse>

//    @GET(GET_PODCAST_GENRES)
//    fun getPodCastGenres(@Query("top_level_only")toplevelOnly:Int,@Header("X-ListenAPI-Key")token: String):Observable<GetPodCastGenreResponse>

    @GET(GET_PODCAST_GENRES)
    fun getPodCastGenres(@Header("X-ListenAPI-Key") token: String): Observable<GetPodCastGenreResponse>

    @GET(GET_PODCAST_METADATA)
    fun getPodCastMetaData(
        @Path("id") metaid: String,
        @Header("X-ListenAPI-Key") token: String
    ): Observable<GetMetaDataResponse>

    @GET(GET_RANDOM_PODCAST)
    fun getRandomPddcast(@Header("X-ListenAPI-Key") token: String): Observable<GetRandomPodcastResponse>


}