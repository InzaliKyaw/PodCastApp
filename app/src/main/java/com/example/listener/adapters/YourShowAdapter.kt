package com.example.listener.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listener.R
import com.example.listener.data.VO.PodcastVO
import com.example.listener.view.vie.viewholder.YourShowViewHolder

class YourShowAdapter(val yourShowList:ArrayList<PodcastVO>): RecyclerView.Adapter<YourShowViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourShowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_yourshow,parent,false)
        return YourShowViewHolder(view)
    }

    override fun getItemCount(): Int {
        return yourShowList.size
    }

    override fun onBindViewHolder(holder: YourShowViewHolder, position: Int) {
        holder.bindYourShow(yourShowList[position])
    }
}