package com.example.listener.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.map
import com.example.listener.data.VO.DownloadVO
import com.example.listener.data.model.PodCastModel
import com.example.listener.data.model.PodCastModelImpl
import com.example.listener.mvp.view.YourShowView
import com.example.listener.persistance.db.PodCastDB
import com.example.listener.player.MediaPlayerImpl

class YourShowPresenterImpl : YourShowPresenter, AbstractBasePresenter<YourShowView>() {

    private lateinit var lifecycleOwner: LifecycleOwner
    private lateinit var mTheDB: PodCastDB
    private var downloadVO: DownloadVO? = null
    var mPodCastModel: PodCastModel = PodCastModelImpl


    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner
        loadAllYourShow(lifecycleOwner)
    }

    override fun loadAllYourShow(lifecycleOwner: LifecycleOwner) {
        mPodCastModel?.getDownloadPodcastFromDB().observe(
            lifecycleOwner, Observer {
                if (it != null) {
                    mView?.displayYourShow(it)
                }
            }
        )

    }

    override fun onTapDownloadPodcast(id: String) {
        mView?.navigateToPodcastDetail(id)

    }

}