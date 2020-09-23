package com.example.listener.data.model

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.listener.data.VO.DownloadVO
import com.example.listener.data.VO.GenreVO
import com.example.listener.network.response.GetMetaDataResponse
import com.example.listener.data.VO.ItemVO
import com.example.listener.network.response.GetRandomPodcastResponse
import com.example.listener.util.LISTEN_API_KEY
import com.example.listener.util.META_ID
import com.example.listener.util.PLAYLIST_ID
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PodCastModelImpl : PodCastModel, BaseModel() {

    private val Tag = "Podcast Impl"

    @SuppressLint("checkresult")
    override fun getPlaylistInfoandItems(playlistId: String): LiveData<List<ItemVO>> {
        mPodCastApi.getPlaylistInfoItems(PLAYLIST_ID, LISTEN_API_KEY).map {
            it.items?.toList() ?: listOf()
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.itemsDao().insertAllItems(it)
                Log.d(Tag, "Get play List" + it)
            }, {
                Log.d(Tag, "Get Play List ERROR" + it)
            }

            )
        return mTheDB.itemsDao().getAllItems()

    }

    @SuppressLint("checkresult")
    override fun getGenres(): LiveData<List<GenreVO>> {
        mPodCastApi.getPodCastGenres(LISTEN_API_KEY).map {
            it.genreVOS?.toList() ?: listOf()
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.genersDao().insertAllGenres(it)
                Log.d(Tag, "Get play List" + it)
            }, {
                Log.d(Tag, "Get Play List ERROR" + it)

            }
            )
        return mTheDB.genersDao().getAllGenres()
    }

    @SuppressLint("checkresult")
    override fun getMetadata(metaId: String): LiveData<GetMetaDataResponse> {
        mPodCastApi.getPodCastMetaData(metaId, LISTEN_API_KEY).map {
            it
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.metaDao().insertAllMetaData(it)
                Log.d(Tag, "Get Pod Cast Meta Data" + it)
            }, {
                Log.d(Tag, "Get Pod Cast Meta Data:ERROR " + it)

            })
        return mTheDB.metaDao().getMetaDataWithId(metaId)
    }

    @SuppressLint("checkresult")
    override fun getRandomPodcast(): LiveData<GetRandomPodcastResponse> {
        mPodCastApi.getRandomPddcast(LISTEN_API_KEY).map {
            it
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.randomDao().insertAllRandomPodcast(it)
                Log.d(Tag, "Get Random Podcast" + it)
            }, {
                Log.d(Tag, "Get Random Podcast" + it)
            })
        return mTheDB.randomDao().getAllRandomPodcast()
    }

    override fun saveDownloadPodcastToDB(downloadVO: DownloadVO) {
        mTheDB.downloadDao().insertAllDownloadVO(downloadVO)
    }

    override fun getDownloadPodcastFromDB(): LiveData<List<DownloadVO>> {

        return mTheDB.downloadDao().getAllDownloadVO()
    }


}