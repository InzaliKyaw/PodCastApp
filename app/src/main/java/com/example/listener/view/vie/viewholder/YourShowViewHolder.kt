package com.example.listener.view.vie.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.listener.data.VO.PodcastVO
import kotlinx.android.synthetic.main.item_yourshow.view.*

class YourShowViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bindYourShow(podcastVO: PodcastVO){
            //itemView.titleYourShow.text = podcastVO.title
            //itemView.descYourShow.text = podcastVO.desc
        }
}