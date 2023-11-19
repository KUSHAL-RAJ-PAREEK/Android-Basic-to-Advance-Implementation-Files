package com.krp.notificationexample

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    val CHANNEL_ID = "my_channel"
    val NOTIFICATION_ID = 1

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val channelName = "Message Channel"
            val channelDesc = "Channel for Message Notifications"

            val NotiChannel = NotificationChannel(CHANNEL_ID,channelName,
                NotificationManager.IMPORTANCE_HIGH).apply{
                description = channelDesc
            }
            notificationManager.createNotificationChannel(NotiChannel)

        }
        val bitmap = (resources.getDrawable(R.drawable.ic_android_black_24dp) as BitmapDrawable).bitmap
        //BigPitureStyle

        val bigpiturestyle = NotificationCompat.BigPictureStyle()
            .bigPicture(bitmap)
            .bigLargeIcon(bitmap)
            .setBigContentTitle("Image")
            .setSummaryText("Image from Ram")

        //inboxstyle
        val inboxStyle = NotificationCompat.InboxStyle()
            .addLine("A")
            .addLine("B")
            .addLine("C")
            .addLine("D")
            .addLine("E")
            .addLine("F")
            .addLine("G")
            .addLine("H")
            .setBigContentTitle("Full Message")
            .setSummaryText("8 Messages from Ram")

        val iNotification = Intent(this, MainActivity::class.java)
        val pi = PendingIntent.getActivity(this,100,iNotification, PendingIntent.FLAG_UPDATE_CURRENT)

        val notification = NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Message")
            .setContentText("New Message from Ram")
            .setSmallIcon(R.drawable.ic_android_black_24dp)
            .setLargeIcon(bitmap)
            .setChannelId(CHANNEL_ID)
            .setContentIntent(pi)
            .setStyle(inboxStyle)
            .setOngoing(true)
            .build()

        notificationManager.notify(NOTIFICATION_ID,notification)
    }
}