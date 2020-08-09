package com.ysydneys.meapplication.data.repository

import com.ysydneys.meapplication.data.remote.RemoteEmployeeSource

class EmployeeRepositoryImpl(private val remoteDataSource: RemoteEmployeeSource) : EmployeeRepository {

    override suspend fun getEmployeeList() = remoteDataSource.getEmployeeList()

    override suspend fun getEmployeeDetail(employeeId: Int) = remoteDataSource.getEmployeeDetail(employeeId)
}