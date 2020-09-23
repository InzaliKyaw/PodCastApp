package com.example.listener.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listener.R
import com.example.listener.adapters.CategoryAdapter
import com.example.listener.data.VO.GenreVO
import com.example.listener.mvp.presenters.CategoriesPresenter
import com.example.listener.mvp.presenters.CategoryPresenterImpl
import com.example.listener.mvp.view.CategoryView
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BaseFragment(), CategoryView {

    private lateinit var mPresenter: CategoriesPresenter
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_search, container, false)
        return view
    }

    companion object {
        fun newInstance(): SearchFragment {

            return SearchFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        mPresenter.onUiReady(this)
        categoryAdapter = CategoryAdapter()
        setUpRecyclerCategory(categoryAdapter)

    }

    fun setUpRecyclerCategory(categoryAdapter: CategoryAdapter) {
        rvCategory.adapter = categoryAdapter
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rvCategory.layoutManager = linearLayoutManager
    }

    fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(CategoryPresenterImpl::class.java)
        mPresenter.initPresenter(this)

    }

    override fun displayCategory(podCastGenreList: List<GenreVO>) {
        categoryAdapter.setNewdata(podCastGenreList.toMutableList())
    }
}