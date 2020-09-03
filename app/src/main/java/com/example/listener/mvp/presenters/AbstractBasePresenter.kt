package com.example.listener.mvp.presenters

import androidx.lifecycle.ViewModel
import com.example.listener.mvp.view.BaseView

abstract class AbstractBasePresenter<T:BaseView>:BasePresenter<T>,ViewModel() {
    var mView:T ?= null

    override fun initPresenter(view: T) {
        mView = view
    }

}