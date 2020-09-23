package com.example.listener.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listener.R
import com.example.listener.data.VO.DownloadVO
import com.example.listener.data.VO.ItemVO
import com.example.listener.data.VO.PodcastVO
import com.example.listener.delegates.DownloadDelegates
import com.example.listener.view.vie.viewholder.YourShowViewHolder

class YourShowAdapter(delegates: DownloadDelegates) : RecyclerView.Adapter<YourShowViewHolder>() {
    var mData: MutableList<DownloadVO> = arrayListOf()
    var downloadDelegates:DownloadDelegates = delegates

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourShowViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_yourshow, parent, false)
        return YourShowViewHolder(view,downloadDelegates)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setNewdata(data: MutableList<DownloadVO>) {
        mData = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: YourShowViewHolder, position: Int) {
        holder.bindYourShow(mData[position])
    }
}