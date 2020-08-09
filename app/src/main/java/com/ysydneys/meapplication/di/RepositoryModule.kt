package com.ysydneys.meapplication.di

import com.ysydneys.meapplication.data.repository.EmployeeRepositoryImpl
import org.koin.dsl.module

val REPOSITORY_MODULE = module {
    single { EmployeeRepositoryImpl(get()) }
}