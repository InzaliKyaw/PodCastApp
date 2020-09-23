package com.example.listener.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.listener.mvp.view.CategoryView

interface CategoriesPresenter : BasePresenter<CategoryView> {

    fun loadAllCategory(lifecycleOwner: LifecycleOwner)
    fun onSwipeRefresh()
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}