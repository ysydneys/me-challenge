package com.ysydneys.meapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    internal val mIsLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> = mIsLoading

    internal val mErrorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = mErrorMessage
}