package com.example.listener.fragments

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.listener.R
import com.example.listener.activity.PodCastDetailActivity
import com.example.listener.adapters.UpNextAdapter
import com.example.listener.data.VO.ItemVO
import com.example.listener.mvp.presenters.MainPresenter
import com.example.listener.mvp.presenters.MainPresenterImpl
import com.example.listener.mvp.view.MainView
import com.example.listener.network.response.GetRandomPodcastResponse
import com.example.listener.util.PermissionUtil
import kotlinx.android.synthetic.main.activity_podcast_detail.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.viewpod_play_back.*


@Suppress("DEPRECATION")
class HomeFragment : BaseFragment(), MainView {

    private lateinit var mPresenter: MainPresenter
    private lateinit var upnextAdapter: UpNextAdapter
    private lateinit var permissionUtil: PermissionUtil


    val TAG: String = "PlayerActivity"

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        hideEmptyView()
        mPresenter.onUiReady(this)

        upnextAdapter = UpNextAdapter(mPresenter)
        setUpRecyclerView(upnextAdapter)

        //Ask permisson for read and write
        permissionUtil = PermissionUtil(this.requireActivity())
        if (!permissionUtil.checkPermissionForReadExternalStorage() ||
            !permissionUtil.checkPermissionForWriteExternalStorage()
        ) {
            permissionUtil.requestPermissions()
        }
        context?.registerReceiver(
            onComplete,
            IntentFilter(
                DownloadManager.ACTION_DOWNLOAD_COMPLETE
            )
        )

    }

    //Download Complete
    private var onComplete: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == DownloadManager.ACTION_DOWNLOAD_COMPLETE) {
                Log.d(TAG, "On Complete")
                mPresenter.saveDownloadPodcast()

            }
        }
    }

    override fun onStart() {
        super.onStart()
        //mPresenter.getPlayer().getPlayerImpl(this.requireContext())
    }

    override fun onResume() {
        super.onResume()
        hideSystemUi()
       // mPresenter.getPlayer().getPlayerImpl(this.requireContext())
    }

    override fun onStop() {
        super.onStop()
       // mPresenter.releasePlayer()
    }

    override fun onPause() {
        super.onPause()
        //mPresenter.releasePlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        activity?.unregisterReceiver(onComplete)
    }

    fun setUpRecyclerView(upNextAdapter: UpNextAdapter) {
        rvPodCast.adapter = upNextAdapter
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvPodCast.layoutManager = linearLayoutManager

    }

    override fun displayPodCast(pod: List<ItemVO>) {
        // setUpRecyclerView(getPodcast())
        upnextAdapter.setNewdata(pod.toMutableList())
    }

    override fun playPodcast(randomVO: GetRandomPodcastResponse) {
        randomTitle.text = randomVO.title
        var randomImageUrl = randomVO.thumbnail
        Glide.with(this)
            .load(randomImageUrl)
            .into(randomImage)
        randomDesc.text = Html.fromHtml(randomVO.description)

        val url = randomVO.audio

        playerControlHome.player = mPresenter.getPlayer().getPlayerImpl(this.requireContext())

        exo_play.setOnClickListener {
            mPresenter.play(url)
        }
        exo_pause.setOnClickListener {
            mPresenter.pause()
        }
        //mPresenter.play(url)

        Log.d("Podcast url", "$url")


    }

    override fun diableSwipeRefresh() {

    }

    override fun enableSwipeRefresh() {
        mPresenter.onSwipeRefresh()
    }

    override fun showEmptyView() {
        vpEmpty.visibility = View.VISIBLE
    }


    override fun hideEmptyView() {
        vpEmpty.visibility = View.GONE
    }

    override fun showErrorMessage(message: String) {

    }

    override fun navigateToPodcastDetail(podcastId: String) {
        startActivity(context?.let { PodCastDetailActivity.newIntent(it, podcastId) })
    }

    fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    @SuppressLint("InlinedApi")
    private fun hideSystemUi() {
        playerControlHome.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }


}