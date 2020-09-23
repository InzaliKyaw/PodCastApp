package com.example.listener.mvp.presenters

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.listener.data.model.PodCastModel
import com.example.listener.data.model.PodCastModelImpl
import com.example.listener.mvp.view.DetailView
import com.example.listener.player.MediaPlayerImpl
import com.example.listener.util.META_ID

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {

    var mPodCastModel: PodCastModel = PodCastModelImpl
    private val mediaPlayer = MediaPlayerImpl()

    private lateinit var lifecycleOwner: LifecycleOwner
    val Tag = "PresenterImpl"
    override fun onUiReady(lifecycleOwner: LifecycleOwner, metaId: String) {
        this.lifecycleOwner = lifecycleOwner
        loadAllMetadata(lifecycleOwner, metaId)
    }

    override fun loadAllMetadata(lifecycleOwner: LifecycleOwner, metaId: String) {
        mPodCastModel.getMetadata(metaId).observe(
            lifecycleOwner, Observer {
                if (it != null) {
                    mView?.displayMetadata(it)
                } else {
                    Log.d(Tag, "PodCastModelImpl" + it)
                }
            }
        )
    }

    override fun getPlayer() = mediaPlayer

    override fun play(url: String) = mediaPlayer.play(url)

    override fun releasePlayer() = mediaPlayer.releasePlayer()

    override fun pause() = mediaPlayer.pause()

}