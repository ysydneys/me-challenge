package com.ysydneys.meapplication.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ysydneys.meapplication.R
import com.ysydneys.meapplication.databinding.ItemEmployeeBinding
import com.ysydneys.meapplication.model.Employee

class EmployeeListAdapter (val onClick: (Int) -> Unit) : RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder>() {

    private var mEmployeeList: List<Employee> = emptyList()

    fun updateEmployeeList(employeeList: List<Employee>) {
        mEmployeeList = employeeList

        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mEmployeeList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EmployeeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_employee,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.itemEmployeeBinding.employeeItem = mEmployeeList[position]

        holder.itemEmployeeBinding.containerLayout.setOnClickListener {
            onClick(mEmployeeList[position].id)
        }
    }

    inner class EmployeeViewHolder(val itemEmployeeBinding: ItemEmployeeBinding) : RecyclerView.ViewHolder(itemEmployeeBinding.root)
}