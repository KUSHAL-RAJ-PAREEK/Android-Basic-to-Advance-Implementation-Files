package com.krp.firebaseexample

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FirebaseToken",token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        message.notification!!.let{
            notifyMessage(it.title, it.body)
        }

    }

    private fun notifyMessage(notiTitle: String?, notiBody: String?) {

        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

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
            .setContentTitle(notiTitle)
            .setContentText(notiBody)
            .setSmallIcon(R.drawable.ic_launcher_background)

        notificationManager.notify(1,notification.build())
    }

}