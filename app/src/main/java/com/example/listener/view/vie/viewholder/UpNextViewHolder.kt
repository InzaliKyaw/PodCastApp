package com.example.listener.view.vie.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.example.listener.data.VO.ItemVO
import com.example.listener.delegates.PodcastDelegates
import kotlinx.android.synthetic.main.item_podcast.view.*

class UpNextViewHolder(itemView: View, private val delegates: PodcastDelegates) :
    BaseUpNextViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            mData?.let {
                //delegates.onTapPodCast(META_ID)

                it.data?.id?.let { it1 -> delegates.onTapPodCast(it1) }

            }
        }
        itemView.downloadBtn.setOnClickListener {
            mData?.let {
                delegates.onTapDownloadImage(it)
            }

        }

    }

     fun bindPodcast(podcastVO: ItemVO) {
        mData = podcastVO
        itemView.titlePodcast.text = podcastVO.data?.title
        var imageUrl = podcastVO.data?.image
        var audio = podcastVO.data?.audio
        Glide.with(itemView)
            .load(imageUrl)
            .into(itemView.imgPodcast)

    }
}