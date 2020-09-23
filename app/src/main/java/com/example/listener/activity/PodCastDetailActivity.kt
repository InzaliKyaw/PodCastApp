package com.example.listener.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.listener.R
import com.example.listener.mvp.presenters.DetailPresenter
import com.example.listener.mvp.presenters.DetailPresenterImpl
import com.example.listener.mvp.view.DetailView
import com.example.listener.network.response.GetMetaDataResponse
import kotlinx.android.synthetic.main.activity_podcast_detail.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.viewpod_play_back.*
import kotlinx.android.synthetic.main.activity_podcast_detail.playerControl as playerControl

class PodCastDetailActivity : BaseActivity(), DetailView {
    companion object {
        fun newIntent(context: Context, metaId: String): Intent {
            val intent = Intent(context, PodCastDetailActivity::class.java)
            intent.putExtra("MetaID", metaId)
            return intent
        }
    }

    private lateinit var mPresenter: DetailPresenter
    private var metaId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_podcast_detail)

        setUpPresenter()
        metaId = intent.getStringExtra("MetaID").toString()
        mPresenter.onUiReady(this, metaId)


    }

    fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun displayMetadata(metaVO: GetMetaDataResponse) {
        titlePodcastDetail.text = metaVO.title
        var htmlAsSpnned:Spanned = Html.fromHtml(metaVO.description)
        descPodCastDetail.text = htmlAsSpnned

        var imageUrl = metaVO.image
        Glide.with(this)
            .load(imageUrl)
            .into(imgDetailPodcast)
        var audioUrl = metaVO.audio
        playerControl.player = mPresenter.getPlayer().getPlayerImpl(this)
        //mPresenter.play(audioUrl)
        Log.d("Podcast Url", "==> $audioUrl")

        exo_play.setOnClickListener {
            mPresenter.play(audioUrl)
        }
        exo_pause.setOnClickListener {
            mPresenter.pause()
        }

    }
}