package com.example.listener.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.listener.delegates.DownloadDelegates
import com.example.listener.mvp.view.BaseView
import com.example.listener.mvp.view.YourShowView
import com.example.listener.player.MediaPlayer

interface YourShowPresenter : BasePresenter<YourShowView>,DownloadDelegates{

    fun onUiReady(lifecycleOwner: LifecycleOwner)
    fun loadAllYourShow(lifecycleOwner: LifecycleOwner)

}