package com.example.expensetracker

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
            Log.d("BootReceiver", "Device rebooted, scheduling service restart")

            val workRequest: WorkRequest = OneTimeWorkRequest.Builder(RestartWorker::class.java).build()
            WorkManager.getInstance(context).enqueue(workRequest)
        }
    }
}
