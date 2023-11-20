package com.krp.workmanagerexample

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, workerParams: WorkerParameters) : Worker(context,workerParams){

    override fun doWork(): Result {
        notifyMessage()
        return Result.success()
    }

    private fun notifyMessage(){

        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                "kushalrajpareek",
                "NotifyMsg",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            notificationManager.createNotificationChannel(channel)
        }

        val notification : NotificationCompat.Builder = NotificationCompat.Builder(
            applicationContext,"kushalrajpareek"
        )
            .setContentTitle("My Work")
            .setContentText("Background task")
            .setSmallIcon(R.drawable.ic_launcher_background)

        notificationManager.notify(1,notification.build())
    }
}