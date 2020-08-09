package com.ysydneys.meapplication.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ysydneys.meapplication.data.ResultWrapper
import com.ysydneys.meapplication.model.Employee
import com.ysydneys.meapplication.ui.BaseViewModel
import com.ysydneys.meapplication.usecases.GetEmployeeListUseCase
import kotlinx.coroutines.launch

class ListViewModel(private val getEmployeeListUseCase: GetEmployeeListUseCase) : BaseViewModel() {

    private val mEmployeeList = MutableLiveData<List<Employee>>()
    val employeeList: LiveData<List<Employee>> = mEmployeeList

    init {
        getEmployeeList()
    }

    fun getEmployeeList() {
        viewModelScope.launch {
            mIsLoading.postValue(true)
            when (val response = getEmployeeListUseCase.invoke()) {
                is ResultWrapper.Success -> {
                    mErrorMessage.postValue("")
                    mEmployeeList.value = response.value
                }
                is ResultWrapper.Error -> mErrorMessage.value = response.errorMessage
            }
            mIsLoading.postValue(false)
        }
    }
}