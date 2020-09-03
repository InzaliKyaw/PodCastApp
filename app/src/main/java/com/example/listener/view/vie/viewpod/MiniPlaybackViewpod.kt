package com.example.listener.view.vie.viewpod

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.viewpod_mini_playback.view.*

class MiniPlaybackViewpod @JvmOverloads constructor(
    context: Context,attrs:AttributeSet ?= null,defStyleSet: Int = 0
):LinearLayout(context,attrs,defStyleSet) {
    override fun onFinishInflate() {
        super.onFinishInflate()
    }
    private fun setUpListener(){
        skipMiniPlayback.setOnClickListener {

        }
        playMiniPlayback.setOnClickListener {

        }
        reverseMiniPlayback.setOnClickListener {

        }
    }
}