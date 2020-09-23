package com.example.listener.fragments

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.listener.mvp.view.BaseView

abstract class BaseFragment : Fragment(), BaseView {
    override fun getAppContext(): Context {
        return requireContext()
    }
}