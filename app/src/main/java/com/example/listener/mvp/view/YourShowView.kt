package com.example.listener.mvp.view

import com.example.listener.data.VO.DownloadVO
import com.example.listener.data.VO.ItemVO

interface YourShowView : BaseView {

    fun displayYourShow(downloadVOList: List<DownloadVO>)
    fun navigateToPodcastDetail(podcastId: String)

}