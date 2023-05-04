package com.arigarasuthan.workmanagerdemo1

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.sql.Date
import java.text.SimpleDateFormat

class UploadWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    companion object {
        const val KEY_WORKER = "key_worker"
    }
    override fun doWork(): Result {
        return try {
            val count = inputData.getInt(MainActivity.KEY_COUNT_VALUE,0)
            for (i in 0 until count) {
                Log.d("MYTAG", "Uploading $i")
            }
            val time = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = time.format(java.util.Date())
            val outputData = Data.Builder()
                .putString(KEY_WORKER,currentDate)
                .build()
            Result.success(outputData)
        } catch (e: java.lang.Exception) {
            Result.failure()
        }
    }
}