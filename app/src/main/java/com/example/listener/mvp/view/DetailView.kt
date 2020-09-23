package com.example.listener.mvp.view

import com.example.listener.network.response.GetMetaDataResponse

interface DetailView : BaseView {

    fun displayMetadata(metaVO: GetMetaDataResponse)
}