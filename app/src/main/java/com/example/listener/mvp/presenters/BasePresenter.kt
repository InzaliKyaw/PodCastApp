package com.example.listener.mvp.presenters

import com.example.listener.fragments.HomeFragment
import com.example.listener.mvp.view.BaseView

interface BasePresenter<T : BaseView> {

    fun initPresenter(view: T)
}