package com.example.listener.mvp.view

import com.example.listener.data.VO.ItemVO
import com.example.listener.network.response.GetRandomPodcastResponse

interface MainView : BaseView {

    //PresenterToView
    fun displayPodCast(pod: List<ItemVO>)
    fun playPodcast(randomVO: GetRandomPodcastResponse)
    fun diableSwipeRefresh()
    fun enableSwipeRefresh()
    fun showEmptyView()
    fun hideEmptyView()
    fun showErrorMessage(message: String)
    fun navigateToPodcastDetail(podcastId: String)
    //fun downloadPodcast(itemVO: ItemVO)
}