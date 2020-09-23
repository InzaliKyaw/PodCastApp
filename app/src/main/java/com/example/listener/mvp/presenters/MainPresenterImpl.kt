package com.example.listener.mvp.presenters

import android.app.DownloadManager
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Environment
import android.util.Log
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.listener.data.VO.DownloadVO
import com.example.listener.data.VO.ItemVO
import com.example.listener.data.model.PodCastModel
import com.example.listener.data.model.PodCastModelImpl
import com.example.listener.mvp.view.MainView
import com.example.listener.player.MediaPlayerImpl
import com.example.listener.util.PLAYLIST_ID
import com.example.listener.util.PermissionUtil
import java.io.File

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    //private var mView:MainView ?= null
    var mPodCastModel: PodCastModel = PodCastModelImpl
    private val mediaPlayer = MediaPlayerImpl()

    var Tag = "PodCast App"
    private lateinit var lifecycleOwner: LifecycleOwner
    private var mItemVO: ItemVO? = null

    override fun loadAllPodCast(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner
        mPodCastModel.getPlaylistInfoandItems(PLAYLIST_ID).observe(
            lifecycleOwner, Observer {
                mView?.displayPodCast(it)
            }
        )
    }

    override fun getPlayer() = mediaPlayer

    override fun play(url: String) = mediaPlayer.play(url)

    override fun releasePlayer() = mediaPlayer.releasePlayer()

    override fun pause() = mediaPlayer.pause()

    override fun loadRandomPodCast(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner
        mPodCastModel.getRandomPodcast().observe(
            lifecycleOwner, Observer {
                if (it != null) {
                    mView?.playPodcast(it)
                } else {
                    mView?.showEmptyView()
                    Log.d(Tag, "Random Podcast" + it)
                }
            }
        )
    }

    override fun onSwipeRefresh() {

    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        loadAllPodCast(lifecycleOwner)
        loadRandomPodCast(lifecycleOwner)
    }


    override fun onTapPodCast(id: String) {
        mView?.navigateToPodcastDetail(id)
    }

    override fun onTapDownloadImage(itemVO: ItemVO) {
        downloadPodcastFile(itemVO)
        mItemVO = itemVO
        // mView?.downloadPodcast(itemVO)
    }

    override fun saveDownloadPodcast() {
        mItemVO?.let {
            val downloadVO = DownloadVO(
                id = it.id,
                type = it.type,
                addedAtMs = it.addedAtMs,
                data = it.data,
                notes = it.notes
            )
            mPodCastModel.saveDownloadPodcastToDB(downloadVO)
        }

    }


    fun downloadPodcastFile(itemVO: ItemVO) {

        var msg: String? = ""
        var lastMsg = ""

        val directory = File(Environment.DIRECTORY_PICTURES)

        if (!directory.exists()) {
            directory.mkdirs()
        }

        val downloadManager =
            mView?.getAppContext()?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager

        val downloadVO = itemVO
        val downloadUri = Uri.parse(downloadVO.data?.audio)

        val request = DownloadManager.Request(downloadUri).apply {
            setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
                .setAllowedOverRoaming(false)
                .setTitle(downloadVO.data?.title)
                .setDescription("Downloading....")
                .setDestinationInExternalPublicDir(
                    Environment.DIRECTORY_DOWNLOADS,
                    "podcast/${downloadVO.data?.title?.trim()}.mp3"
                )

        }


        val downloadId = downloadManager.enqueue(request)
        val query = DownloadManager.Query().setFilterById(downloadId)
        Thread(Runnable {
            var downloading = true
            while (downloading) {
                val cursor: Cursor = downloadManager.query(query)
                cursor.moveToFirst()
                if (cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS)) == DownloadManager.STATUS_SUCCESSFUL) {
                    downloading = false
                }
                val status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS))
                msg = statusMessage(directory, status)
                if (msg != lastMsg) {
//                    this.runOnUiThread{
//                        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
//                    }
                    lastMsg = msg ?: ""
                }
                cursor.close()
            }
        }).start()
    }

    private fun statusMessage(directory: File, status: Int): String? {
        var msg = ""
        msg = when (status) {
            DownloadManager.STATUS_FAILED -> "Download has been failed, please try again"
            DownloadManager.STATUS_PAUSED -> "Paused"
            DownloadManager.STATUS_PENDING -> "Pending"
            DownloadManager.STATUS_RUNNING -> "Downloading..."
            DownloadManager.STATUS_SUCCESSFUL -> "Image downloaded successfully in $directory" + File.separator + 1
            else -> "There's nothing to download"
        }
        return msg
    }
}