package com.ysydneys.meapplication.di

import com.ysydneys.meapplication.data.remote.RemoteEmployeeSource
import org.koin.dsl.module

val DATA_SOURCE_MODULE = module {
    factory { RemoteEmployeeSource(get()) }
}