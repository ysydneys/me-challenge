package com.ysydneys.meapplication.usecases

import com.ysydneys.meapplication.data.ResultWrapper
import com.ysydneys.meapplication.data.repository.EmployeeRepository
import com.ysydneys.meapplication.data.repository.EmployeeRepositoryImpl
import com.ysydneys.meapplication.model.Employee

class GetEmployeeListUseCase(private val repository: EmployeeRepositoryImpl) {

    suspend fun invoke() : ResultWrapper<List<Employee>> = repository.getEmployeeList()
}