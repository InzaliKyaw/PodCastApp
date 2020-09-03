package com.example.listener.data.model

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.listener.data.VO.ItemVO
import com.example.listener.util.LISTEN_API_KEY
import com.example.listener.util.PLAYLIST_ID
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object PodCastModelImpl:PodCastModel,BaseModel() {

    private val Tag = "Podcast Impl"

    @SuppressLint("checkresult")
    override fun getPlaylistInfoandItems(playlistId: String): LiveData<List<ItemVO>> {
        mPodCastApi.getPlaylistInfoItems(PLAYLIST_ID,LISTEN_API_KEY).map {
            it.items?.toList() ?: listOf()
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTheDB.itemsDao().insertAllItems(it)
                Log.d(Tag,"Get play List"+it)
            },{
                Log.d(Tag,"Get Play List ERROR"+ it)
            }

            )
        return mTheDB.itemsDao().getAllItems()

    }


}