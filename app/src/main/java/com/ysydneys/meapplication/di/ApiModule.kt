package com.ysydneys.meapplication.di

import com.ysydneys.meapplication.api.EMPLOYEE_API_ENDPOINT
import com.ysydneys.meapplication.api.EmployeeService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val API_MODULE = module {
    // ok http client
    factory {
        OkHttpClient.Builder().build()
    }

    // retrofit
    factory {
        Retrofit.Builder()
            .baseUrl("$EMPLOYEE_API_ENDPOINT")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }
    
    factory {
        val retrofit: Retrofit = get()
        retrofit.create(EmployeeService::class.java)
    }
}