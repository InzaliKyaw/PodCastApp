package com.example.listener.mvp.view

import android.provider.MediaStore
import com.example.listener.data.VO.GenreVO

interface CategoryView : BaseView {

    fun displayCategory(podCastGenreList: List<GenreVO>)
}