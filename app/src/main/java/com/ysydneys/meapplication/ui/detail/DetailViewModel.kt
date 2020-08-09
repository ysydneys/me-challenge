package com.ysydneys.meapplication.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ysydneys.meapplication.data.ResultWrapper
import com.ysydneys.meapplication.model.Employee
import com.ysydneys.meapplication.ui.BaseViewModel
import com.ysydneys.meapplication.usecases.GetEmployeeDetailUseCase
import kotlinx.coroutines.launch

class DetailViewModel(private val getEmployeeDetailUseCase: GetEmployeeDetailUseCase) : BaseViewModel() {

    private val mEmployeeDetail = MutableLiveData<Employee>()
    val employeeDetail: LiveData<Employee> = mEmployeeDetail

    fun getEmployeeDetail(employeeId: Int) {
        viewModelScope.launch {
            mIsLoading.postValue(true)
            when (val response = getEmployeeDetailUseCase.invoke(employeeId)) {
                is ResultWrapper.Success -> {
                    mErrorMessage.postValue("")
                    mEmployeeDetail.value = response.value
                }
                is ResultWrapper.Error -> mErrorMessage.value = response.errorMessage
            }
            mIsLoading.postValue(false)
        }
    }
}