package com.ysydneys.meapplication

import android.app.Application
import com.ysydneys.meapplication.di.*
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
                    USE_CASE_MODULE,
                    VIEW_MODEL_MODULE
                )
            )
        }
    }
}