package com.example.listener.view.vie.viewpod

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.viewpod_play_back.view.*

class PlaybackViewpod @JvmOverloads constructor(
    context: Context, attrs:AttributeSet ? = null, detStyleAttr:Int = 0
):RelativeLayout(context,attrs,detStyleAttr){
    override fun onFinishInflate() {
        super.onFinishInflate()
    }
    private fun setUpListener(){
        skip.setOnClickListener {

        }
        pause.setOnClickListener {

        }
        reverse.setOnClickListener {

        }
    }
}