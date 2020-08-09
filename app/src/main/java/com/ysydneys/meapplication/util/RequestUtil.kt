package com.ysydneys.meapplication.util

import com.ysydneys.meapplication.data.ResultWrapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.lang.Exception

suspend fun <T> executeNetworkRequest(
    dispatcher: CoroutineDispatcher,
    request: suspend() -> T
) : ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(request.invoke())
        } catch (e: Exception) {
            ResultWrapper.Error(e.message)
        }
    }
}