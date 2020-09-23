package com.example.listener.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.listener.data.model.PodCastModel
import com.example.listener.data.model.PodCastModelImpl
import com.example.listener.mvp.view.CategoryView

class CategoryPresenterImpl : CategoriesPresenter, AbstractBasePresenter<CategoryView>() {

    var mPodCastModel: PodCastModel = PodCastModelImpl
    private lateinit var lifecycleOwner: LifecycleOwner

    override fun loadAllCategory(lifecycleOwner: LifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner
        mPodCastModel.getGenres().observe(
            lifecycleOwner, Observer {
                mView?.displayCategory(it)
            }
        )
    }

    override fun onSwipeRefresh() {

    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        loadAllCategory(lifecycleOwner)
    }
}