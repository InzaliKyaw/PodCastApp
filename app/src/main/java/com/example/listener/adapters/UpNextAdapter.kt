package com.example.listener.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listener.R
import com.example.listener.data.VO.ItemVO
import com.example.listener.mvp.presenters.MainPresenter
import com.example.listener.view.vie.viewholder.UpNextViewHolder

class UpNextAdapter() : RecyclerView.Adapter<UpNextViewHolder>() {
    var mData:MutableList<ItemVO> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpNextViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_podcast,parent,false)
        return UpNextViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setNewdata(data:MutableList<ItemVO>){
        mData = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: UpNextViewHolder, position: Int) {
        holder.bindPodcast(mData[position])
    }
}