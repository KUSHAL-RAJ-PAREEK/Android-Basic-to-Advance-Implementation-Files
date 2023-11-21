package com.krp.sendingreceivingmsgs

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsManager
import android.telephony.SmsMessage
import android.util.Log

class MyMessageReceiver : BroadcastReceiver(){

    @SuppressLint("UnsafeProtectedBroadcastReceiver")
    override fun onReceive(context: Context?, intent: Intent?) {

        val bundle = intent!!.extras

        bundle!!.let {

           val pduObject =  it.get("pdus") as Array<*>
            var msg = ""

            for(item in pduObject){

                val smsMessage = SmsMessage.createFromPdu(item as ByteArray, it.getString("format"))

                msg = "From: ${smsMessage.displayOriginatingAddress},Msg: ${smsMessage.displayMessageBody}"

                Log.d("MessageDetails",msg)

            }

            val smsManager = SmsManager.getDefault()

            smsManager.sendTextMessage("9829975575",
                null,
                msg,
                null,
                null)

        }
    }
}