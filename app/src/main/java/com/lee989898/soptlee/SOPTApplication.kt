package com.lee989898.soptlee

import android.app.Application
import com.lee989898.soptlee.data.LocalPreferences
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class SOPTApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initTimber()
        LocalPreferences.init(this)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}