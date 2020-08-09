package com.ysydneys.meapplication.data.remote

import com.ysydneys.meapplication.api.EmployeeService
import com.ysydneys.meapplication.data.EmployeeSource
import com.ysydneys.meapplication.data.ResultWrapper
import com.ysydneys.meapplication.model.Employee
import com.ysydneys.meapplication.util.executeNetworkRequest
import kotlinx.coroutines.Dispatchers

class RemoteEmployeeSource(private val service: EmployeeService) : EmployeeSource {

    override suspend fun getEmployeeList() : ResultWrapper<List<Employee>> {
        return executeNetworkRequest(Dispatchers.IO) {
            service.getEmployeeList()
        }
    }

    override suspend fun getEmployeeDetail(employeeId: Int) : ResultWrapper<Employee> {
        return executeNetworkRequest(Dispatchers.IO) {
            service.getEmployeeDetail(employeeId)
        }
    }
}