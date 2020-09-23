package com.example.listener.view.vie.viewholder

import android.text.Html
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listener.data.VO.DownloadVO
import com.example.listener.data.VO.ItemVO
import com.example.listener.data.VO.PodcastVO
import com.example.listener.delegates.DownloadDelegates
import kotlinx.android.synthetic.main.item_yourshow.view.*

class YourShowViewHolder(itemView: View,private val delegates: DownloadDelegates) : BaseYourShowViewHolder(itemView) {
    init {
        itemView.setOnClickListener {
            mData?.let {
                it.data?.id?.let { it1 -> delegates.onTapDownloadPodcast(it1) }
            }
        }
    }
    fun bindYourShow(downloadVO: DownloadVO) {
        mData = downloadVO
        itemView.titleYourShow.text = downloadVO.data?.title
        itemView.descYourShow.text = Html.fromHtml(downloadVO.data?.description)
        var imageUrl = downloadVO.data?.image
        Glide.with(itemView)
            .load(imageUrl)
            .into(itemView.yourShowImage)
    }


}