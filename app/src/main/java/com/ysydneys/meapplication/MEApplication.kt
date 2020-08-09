package com.ysydneys.meapplication

import android.app.Application
import com.ysydneys.meapplication.di.API_MODULE
import com.ysydneys.meapplication.di.DATA_SOURCE_MODULE
import com.ysydneys.meapplication.di.REPOSITORY_MODULE
import com.ysydneys.meapplication.di.USE_CASE_MODULE
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MEApplication  : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MEApplication)
            modules(
                listOf(
                    API_MODULE,
                    DATA_SOURCE_MODULE,
                    REPOSITORY_MODULE,
                    USE_CASE_MODULE
                )
            )
        }
    }
}