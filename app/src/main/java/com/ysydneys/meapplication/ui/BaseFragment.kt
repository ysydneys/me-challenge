package com.ysydneys.meapplication.ui

import android.content.Context
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    lateinit var fragmentListener: FragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentListener) {
            fragmentListener = context
        }
        else {
            throw ClassCastException("$context must implement FragmentListener")
        }
    }

    interface FragmentListener {
        fun showProgressBar()
        fun hideProgressBar()
        fun onEmployeeSelected(selectedEmployeeId: Int)
        fun showToastMessage(message: String)
    }
}