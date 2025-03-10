package com.example.expensetracker

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class RestartWorker(context: Context, params: WorkerParameters) : Worker(context, params) {
    override fun doWork(): Result {
        Log.d("RestartWorker", "Restarting ForegroundSmsService")
        val serviceIntent = Intent(applicationContext, ForegroundSmsService::class.java)
        applicationContext.startForegroundService(serviceIntent)
        return Result.success()
    }
}
