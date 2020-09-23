package com.example.listener.view.vie.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.listener.data.VO.GenreVO
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindCategory(genreVO: GenreVO) {
        itemView.categoryName.text = genreVO.name
    }
}