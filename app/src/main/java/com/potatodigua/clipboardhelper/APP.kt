package com.potatodigua.clipboardhelper

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log


class APP : Application() {

    private var mActivityCount = 0

    companion object {
        private lateinit var instance: APP
        val INSTANCE
            get() = instance;
        private val TAG = APP::class.java.canonicalName
        val isAppForeground
            get() = instance.mActivityCount > 0
    }

    init {
        instance = this
    }

    override fun onCreate() {
        instance = this
        super.onCreate()

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                Log.d(TAG, "onActivityCreated")
            }

            override fun onActivityStarted(activity: Activity) {
                Log.d(TAG, "onActivityStarted")
                mActivityCount++
            }

            override fun onActivityResumed(activity: Activity) {
                Log.d(TAG, "onActivityResumed")
            }

            override fun onActivityPaused(activity: Activity) {
                Log.d(TAG, "onActivityPaused")
            }

            override fun onActivityStopped(activity: Activity) {
                Log.d(TAG, "onActivityStopped")
                mActivityCount--
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                Log.d(TAG, "onActivitySaveInstanceState")
            }

            override fun onActivityDestroyed(activity: Activity) {
                Log.d(TAG, "onActivityDestroyed")
            }
        })

    }

}