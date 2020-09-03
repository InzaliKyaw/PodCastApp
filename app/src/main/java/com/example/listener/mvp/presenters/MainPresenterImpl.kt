package com.example.listener.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.listener.data.model.PodCastModel
import com.example.listener.data.model.PodCastModelImpl
import com.example.listener.mvp.view.MainView
import com.example.listener.util.PLAYLIST_ID

class MainPresenterImpl:MainPresenter,AbstractBasePresenter<MainView>(){

    //private var mView:MainView ?= null
    var mPodCastModel:PodCastModel = PodCastModelImpl
    var Tag = "PodCast App"
    private lateinit var lifecycleOwner: LifecycleOwner

    override fun loadAllPodCast(lifecycleOwner: LifecycleOwner) {
     this.lifecycleOwner = lifecycleOwner
     mPodCastModel.getPlaylistInfoandItems(PLAYLIST_ID).observe(
         lifecycleOwner, Observer {
             mView?.displayPodCast(it)
         }
     )
    }

    override fun onSwipeRefresh() {

    }


    override fun onTapPodCast(id: Int) {

    }
}