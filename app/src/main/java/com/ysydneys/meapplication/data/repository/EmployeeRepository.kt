package com.ysydneys.meapplication.data.repository

import com.ysydneys.meapplication.data.ResultWrapper
import com.ysydneys.meapplication.model.Employee

interface EmployeeRepository {

    suspend fun getEmployeeList() : ResultWrapper<List<Employee>>

    suspend fun getEmployeeDetail(employeeId: Int) : ResultWrapper<Employee>
}