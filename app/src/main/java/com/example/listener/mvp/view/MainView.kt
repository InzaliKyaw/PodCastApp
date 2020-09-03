package com.example.listener.mvp.view

import com.example.listener.data.VO.ItemVO

interface MainView:BaseView {

    //PresenterToView
    fun displayPodCast(pod: List<ItemVO>)
    fun diableSwipeRefresh()
    fun enableSwipeRefresh()
    fun showEmptyView()
    fun hideEmptyView()
    fun showErrorMessage(message:String)
    fun navigateToPodcastDetail(podcastId:Int)
}