package com.ysydneys.meapplication.usecases

import com.ysydneys.meapplication.data.ResultWrapper
import com.ysydneys.meapplication.data.repository.EmployeeRepository
import com.ysydneys.meapplication.model.Employee

class GetEmployeeDetailUseCase(private val repository: EmployeeRepository) {

    suspend fun invoke(employeeId: Int) : ResultWrapper<Employee> = repository.getEmployeeDetail()
}