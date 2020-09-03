package com.example.listener.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listener.R
import com.example.listener.adapters.YourShowAdapter
import kotlinx.android.synthetic.main.fragment_your_show.*

class YourShowsFragment:Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_your_show,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setUpRecyclerYourShow()
    }

//    fun setUpRecyclerYourShow(){
//        val yourShowAdapter = YourShowAdapter(getPodcast())
//        rvYourShow.adapter = yourShowAdapter
//        val linearLayoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
//        rvYourShow.layoutManager = linearLayoutManager
//
//    }
}