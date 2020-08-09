package com.ysydneys.meapplication.di

import com.ysydneys.meapplication.usecases.GetEmployeeDetailUseCase
import com.ysydneys.meapplication.usecases.GetEmployeeListUseCase
import org.koin.dsl.module

val USE_CASE_MODULE = module {
    factory { GetEmployeeListUseCase(get()) }
    factory { GetEmployeeDetailUseCase(get()) }
}