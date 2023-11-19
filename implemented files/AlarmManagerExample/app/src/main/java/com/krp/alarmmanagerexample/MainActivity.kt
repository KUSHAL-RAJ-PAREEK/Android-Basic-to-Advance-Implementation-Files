package com.krp.alarmmanagerexample

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.getSystemService
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.krp.alarmmanagerexample.MainActivity.Companion.CHANNEL_ID
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        createNotificationChannel()


        val timePicker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(Calendar.getInstance().get(Calendar.HOUR_OF_DAY))
            .setMinute(Calendar.getInstance().get(Calendar.MINUTE))
            .setTitleText("Select Alarm Time")
            .build()
        timePicker.show(supportFragmentManager,"Kushalrajpareek")

        timePicker.addOnPositiveButtonClickListener {

            val cal = Calendar.getInstance()
            cal[Calendar.HOUR_OF_DAY] = timePicker.hour
            cal[Calendar.MINUTE] = timePicker.minute
            cal[Calendar.SECOND] = 0
            cal[Calendar.MILLISECOND] = 0

            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

            val iBroadCAST = Intent(this, MyBroadcastReceiver::class.java)
            val pi = PendingIntent.getBroadcast(this,0,iBroadCAST, 0)

            alarmManager.set(AlarmManager.RTC_WAKEUP, cal.timeInMillis, pi)
        }






    }

    companion object{
        val CHANNEL_ID = "1"

    val CHANNEL_NAME = "Message Channel"
    }

    private fun createNotificationChannel() {

        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){


            val channelDesc = "Channel for Message Notifications"

            val notiChannel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = channelDesc
            }
            notificationManager.createNotificationChannel(notiChannel)
    }
}
}