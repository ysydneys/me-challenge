package com.ysydneys.meapplication.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.ysydneys.meapplication.R
import com.ysydneys.meapplication.model.Employee
import com.ysydneys.meapplication.ui.BaseFragment
import kotlinx.android.synthetic.main.detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val ARG_EMPLOYEE_ID = "ARG_EMPLOYEE_ID"

class DetailFragment : BaseFragment() {

    companion object {
        fun newInstance(employeeId: Int) = DetailFragment().apply {
            arguments = Bundle().apply {
                putInt(ARG_EMPLOYEE_ID, employeeId)
            }
        }
    }

    private val viewModel: DetailViewModel by viewModel()
    private var employeeId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            employeeId = it.getInt(ARG_EMPLOYEE_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        refreshData(employeeId)
    }

    private fun observe() {
        viewModel.employeeDetail.observe(viewLifecycleOwner, Observer {
            populateEmployeeData(it)
            fragmentListener.showToastMessage("id: ${it.id}")
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

    private fun refreshData(employeeId: Int?) {
        viewModel.getEmployeeDetail(employeeId ?: -1)
    }

    private fun populateEmployeeData(employee: Employee) {
        val data = android.util.Base64.decode(employee.image, android.util.Base64.DEFAULT)
        Glide.with(this).load(data).fitCenter().placeholder(R.drawable.ic_gender_24).into(employeeImage)
        employeeName.text = "${employee.first_name}, ${employee.last_name}"
        employeeGender.text = if (employee.gender.toLowerCase() == "male") "Male" else "Female"
        employeeDoB.text = employee.birth_date
    }
}