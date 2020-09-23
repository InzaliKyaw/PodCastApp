package com.example.listener.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.listener.mvp.view.DetailView
import com.example.listener.player.MediaPlayer

interface DetailPresenter : BasePresenter<DetailView> {

    fun onUiReady(lifecycleOwner: LifecycleOwner, metaId: String)
    fun loadAllMetadata(lifecycleOwner: LifecycleOwner, metaId: String)
    fun getPlayer(): MediaPlayer
    fun play(url: String)
    fun releasePlayer()
    fun pause()
}