package com.krp.alarmmanagerexample

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import androidx.core.app.NotificationCompat

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        
        Notify(context)

    }

    private fun Notify(context: Context?) {

        val notification = NotificationCompat.Builder(
            context!!.applicationContext, MainActivity.CHANNEL_ID)
            .setContentTitle("Message")
            .setContentText("New Message from Ram")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setChannelId(MainActivity.CHANNEL_ID)
            .build()


        (context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager)
            .notify(1,notification)
    }
}