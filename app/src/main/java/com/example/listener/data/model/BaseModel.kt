package com.example.listener.data.model

import android.content.Context
import com.example.listener.data.PodcastApi
import com.example.listener.persistance.db.PodCastDB
import com.example.listener.util.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

abstract class BaseModel {
    protected var mPodCastApi: PodcastApi
    protected lateinit var mTheDB: PodCastDB

    init {
        val mokhttpclient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mokhttpclient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mPodCastApi = retrofit.create(PodcastApi::class.java)

    }

    fun initDatabase(context: Context) {
        mTheDB = PodCastDB.getdbInstance(context)
    }


}