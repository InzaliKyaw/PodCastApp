package com.example.listener.view.vie.viewpod

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.ui.PlayerControlView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import kotlinx.android.synthetic.main.fragment_home.view.*
import okhttp3.internal.Util

class ExoPlayerViewPod @JvmOverloads constructor(
    context: Context, attrs:AttributeSet ? = null, detStyleAttr:Int = 0
): PlayerControlView(context,attrs,detStyleAttr) {

    override fun onFinishInflate() {
        super.onFinishInflate()
        // initializePlayer()
    }
}