package com.ysydneys.meapplication.data.repository

import com.ysydneys.meapplication.data.ResultWrapper
import com.ysydneys.meapplication.data.remote.RemoteEmployeeSource
import com.ysydneys.meapplication.model.Employee

class EmployeeRepositoryImpl(private val remoteDataSource: RemoteEmployeeSource) : EmployeeRepository {

    override suspend fun getEmployeeList() : ResultWrapper<List<Employee>> {
        TODO("Not yet implemented")
    }

    override suspend fun getEmployeeDetail() : ResultWrapper<Employee> {
        TODO("Not yet implemented")
    }
}