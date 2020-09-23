package com.example.listener.view.vie.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.listener.data.VO.PodcastVO

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var mData: T? = null
   // abstract fun bindPodcast(podcastVO: T)
}