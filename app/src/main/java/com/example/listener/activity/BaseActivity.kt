package com.example.listener.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.listener.mvp.view.BaseView

abstract class BaseActivity:AppCompatActivity(),BaseView{
    override fun getAppContext(): Context {
        return this
    }
}