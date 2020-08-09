package com.ysydneys.meapplication.data

sealed class ResultWrapper<out T> {

    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class Error(val errorMessage: String?) : ResultWrapper<Nothing>()
}