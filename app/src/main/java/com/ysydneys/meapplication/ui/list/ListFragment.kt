package com.ysydneys.meapplication.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ysydneys.meapplication.R
import com.ysydneys.meapplication.ui.BaseFragment
import kotlinx.android.synthetic.main.list_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : BaseFragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private val viewModel: ListViewModel by viewModel()
    private val mEmployeeListAdapter = EmployeeListAdapter(this::onEmployeeItemClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observe()
    }

    private fun observe() {
        viewModel.employeeList.observe(viewLifecycleOwner, Observer { list ->
            recyclerView.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.adapter = mEmployeeListAdapter
                it.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                mEmployeeListAdapter.updateEmployeeList(list)
            }
            fragmentListener.showToastMessage("Total: ${list.size}")
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            if (it) {
                fragmentListener.showProgressBar()
            } else {
                fragmentListener.hideProgressBar()
            }
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                fragmentListener.showToastMessage(it)
            }
        })
    }

    private fun onEmployeeItemClick(employeeId: Int) {
        fragmentListener.onEmployeeSelected(employeeId)
    }
}