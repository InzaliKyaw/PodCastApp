package com.example.listener.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listener.R
import com.example.listener.activity.PodCastDetailActivity
import com.example.listener.adapters.YourShowAdapter
import com.example.listener.data.VO.DownloadVO
import com.example.listener.mvp.presenters.*
import com.example.listener.mvp.view.YourShowView
import kotlinx.android.synthetic.main.fragment_your_show.*

class YourShowsFragment : BaseFragment(), YourShowView {

    private lateinit var mPresenter: YourShowPresenter
    private lateinit var yourShowAdapter: YourShowAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_your_show, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        mPresenter.onUiReady(this)
        yourShowAdapter = YourShowAdapter(mPresenter)
        setUpRecyclerYourShow()
    }


    fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(YourShowPresenterImpl::class.java)
        mPresenter.initPresenter(this)

    }


    fun setUpRecyclerYourShow() {
        rvYourShow.adapter = yourShowAdapter
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvYourShow.layoutManager = linearLayoutManager

    }

    override fun displayYourShow(downloadVOList: List<DownloadVO>) {
        yourShowAdapter.setNewdata(downloadVOList.toMutableList())
    }

    override fun navigateToPodcastDetail(podcastId: String) {
        startActivity(context.let { it?.let { it1 -> PodCastDetailActivity.newIntent(it1,podcastId) } })
    }
}