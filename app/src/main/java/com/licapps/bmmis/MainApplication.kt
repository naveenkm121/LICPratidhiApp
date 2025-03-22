package com.licapps.bmmis

import android.app.Application
import com.licapps.bmmis.constants.AppConstants


import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (AppConstants.EnableLogging) {
            Timber.plant(Timber.DebugTree())
        }
    }

}