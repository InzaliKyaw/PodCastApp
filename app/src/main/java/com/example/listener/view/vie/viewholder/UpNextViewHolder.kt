package com.example.listener.view.vie.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.listener.data.VO.ItemVO
import kotlinx.android.synthetic.main.item_podcast.view.*

class UpNextViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
    fun bindPodcast(podcastVO: ItemVO){
        itemView.titlePodcast.text = podcastVO.data.title

    }
}