package com.ysydneys.meapplication.api

import com.ysydneys.meapplication.model.Employee
import retrofit2.http.GET
import retrofit2.http.Path

interface EmployeeService {

    @GET("/employees")
    suspend fun getEmployeeList() : List<Employee>

    @GET("/employees/{employee_id}")
    suspend fun getEmployeeDetail(@Path("employee_id") employeeId: Int) : Employee
}