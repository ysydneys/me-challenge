package com.ysydneys.meapplication.data

import com.ysydneys.meapplication.model.Employee

interface EmployeeSource {

    suspend fun getEmployeeList() : ResultWrapper<List<Employee>>
    suspend fun getEmployeeDetail(employeeId: Int) : ResultWrapper<Employee>
}