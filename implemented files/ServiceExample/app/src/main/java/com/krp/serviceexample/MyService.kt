package com.krp.serviceexample

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.widget.Toast

class MyService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Handler().postDelayed(object: Runnable{
            override fun run() {
               Toast.makeText(applicationContext,"Service Running!",Toast.LENGTH_SHORT).show()
            }

        },10000)
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}