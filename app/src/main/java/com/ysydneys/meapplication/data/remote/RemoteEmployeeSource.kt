package com.ysydneys.meapplication.data.remote

import com.ysydneys.meapplication.api.EmployeeService
import com.ysydneys.meapplication.data.EmployeeSource
import com.ysydneys.meapplication.data.ResultWrapper
import com.ysydneys.meapplication.model.Employee

class RemoteEmployeeSource(private val service: EmployeeService) : EmployeeSource {

    override suspend fun getEmployeeList() : ResultWrapper<List<Employee>> {
        TODO("Not yet implemented")
    }

    override suspend fun getEmployeeDetail(employeeId: Int) : ResultWrapper<Employee> {
        TODO("Not yet implemented")
    }
}