package com.arigarasuthan.servicedemoapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyBackgroundService : Service() {

    init {
        Log.i(TAG, "Service has been created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "Service Started")
        val name = intent?.getStringExtra(KEY_NAME)
        val mark = intent?.getIntExtra(MARKS,0)
        Log.i(TAG,"Name is $name Marks : $mark")
        return START_STICKY
    }

    override fun onDestroy() {
        Log.i(TAG, "Service Destroyed")
        super.onDestroy()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    companion object {
        const val TAG = "MYTAG"
        const val KEY_NAME = "NAME"
        const val MARKS = "TOTAL MARKS"
    }
}