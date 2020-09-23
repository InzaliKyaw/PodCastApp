package com.example.listener

import android.app.Application
import android.content.Context
import android.net.Uri
import com.example.listener.data.model.PodCastModelImpl
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util

class PodCastApp : Application() {

    override fun onCreate() {
        super.onCreate()
        PodCastModelImpl.initDatabase(applicationContext)
    }
}