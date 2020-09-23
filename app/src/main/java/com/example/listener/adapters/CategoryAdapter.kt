package com.example.listener.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listener.R
import com.example.listener.data.VO.GenreVO
import com.example.listener.data.VO.ItemVO
import com.example.listener.view.vie.viewholder.CategoryViewHolder
import kotlinx.android.synthetic.main.fragment_search.*

class CategoryAdapter : RecyclerView.Adapter<CategoryViewHolder>() {

    var mData: MutableList<GenreVO> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setNewdata(data: MutableList<GenreVO>) {
        mData = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bindCategory(mData[position])
    }
}