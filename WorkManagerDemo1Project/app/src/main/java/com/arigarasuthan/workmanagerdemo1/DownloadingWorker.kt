package com.arigarasuthan.workmanagerdemo1

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.text.SimpleDateFormat

class DownloadingWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        return try {
            for (i in 0 ..3000) {
                Log.d("MYTAG", "Downloading $i")
            }
            val time = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = time.format(java.util.Date())
            Log.d("MYTAG","Completed $currentDate")
            Result.success()
        } catch (e: java.lang.Exception) {
            Result.failure()
        }
    }
}