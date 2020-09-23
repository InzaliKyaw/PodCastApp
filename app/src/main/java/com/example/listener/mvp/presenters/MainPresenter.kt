package com.example.listener.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.listener.delegates.PodcastDelegates
import com.example.listener.mvp.presenters.BasePresenter
import com.example.listener.mvp.view.MainView
import com.example.listener.player.MediaPlayer

interface MainPresenter : BasePresenter<MainView>, PodcastDelegates {
    //Staus update
    fun loadAllPodCast(lifecycleOwner: LifecycleOwner)
    fun loadRandomPodCast(lifecycleOwner: LifecycleOwner)
    fun onSwipeRefresh()
    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun saveDownloadPodcast()

    fun pause()

    fun getPlayer(): MediaPlayer

    fun play(url: String)

    fun releasePlayer()
}