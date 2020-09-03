package com.example.listener.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.listener.delegates.PodcastDelegates
import com.example.listener.mvp.presenters.BasePresenter
import com.example.listener.mvp.view.MainView

interface MainPresenter:BasePresenter<MainView>,PodcastDelegates{
   //Staus update
   fun loadAllPodCast(lifecycleOwner: LifecycleOwner)
   fun onSwipeRefresh()
}