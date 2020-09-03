package com.example.listener

import android.app.Application
import com.example.listener.data.model.PodCastModelImpl

class PodCastApp:Application(){
    override fun onCreate() {
        super.onCreate()
        PodCastModelImpl.initDatabase(applicationContext)
    }
}