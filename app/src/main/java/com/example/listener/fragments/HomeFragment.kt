package com.example.listener.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listener.R
import com.example.listener.adapters.UpNextAdapter
import com.example.listener.data.VO.ItemVO
import com.example.listener.mvp.presenters.MainPresenter
import com.example.listener.mvp.presenters.MainPresenterImpl
import com.example.listener.mvp.view.MainView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment:Fragment(),MainView{
    private lateinit var mPresenter:MainPresenter
    private lateinit var upnextAdapter:UpNextAdapter
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        arguments.let {
//            param1 = it?.getString(ARG_PARAM1)
//            param2 = it?.getString(ARG_PARAM2)
//        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_home,container,false)
        return view
    }
    companion object{
        fun newInstance():HomeFragment{

            return HomeFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        upnextAdapter = UpNextAdapter()
        setUpRecyclerView(upnextAdapter)


        //setUpRecyclerView(getPodcast())
    }

    fun setUpRecyclerView(upNextAdapter: UpNextAdapter){
        rvPodCast.adapter = upNextAdapter
        val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rvPodCast.layoutManager = linearLayoutManager

    }

    override fun displayPodCast(pod: List<ItemVO>) {
       // setUpRecyclerView(getPodcast())
        upnextAdapter.setNewdata(pod.toMutableList())
    }

    override fun diableSwipeRefresh() {

    }

    override fun enableSwipeRefresh() {
        mPresenter.onSwipeRefresh()
    }

    override fun showEmptyView() {
    }


    override fun hideEmptyView() {

    }

    override fun showErrorMessage(message: String) {

    }

    override fun navigateToPodcastDetail(podcastId: Int) {

    }


    fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)

    }


}