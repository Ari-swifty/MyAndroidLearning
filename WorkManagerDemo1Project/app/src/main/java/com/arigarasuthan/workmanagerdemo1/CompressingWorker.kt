package com.arigarasuthan.workmanagerdemo1

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class CompressingWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        return try {
            for (i in 0 ..300) {
                Log.d("MYTAG", "Compressing $i")
            }
            Result.success()
        } catch (e: java.lang.Exception) {
            Result.failure()
        }
    }
}