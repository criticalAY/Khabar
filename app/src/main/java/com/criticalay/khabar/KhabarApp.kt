package com.criticalay.khabar

import android.app.Application
import timber.log.Timber

class KhabarApp:Application() {
    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}