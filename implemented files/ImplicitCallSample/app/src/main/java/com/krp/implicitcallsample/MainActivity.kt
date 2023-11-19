package com.krp.implicitcallsample

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krp.implicitcallsample.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btndail.setOnClickListener {

            val number = Uri.parse("tel:9414696844")
            val iDial = Intent(Intent.ACTION_DIAL,number)
            startActivity(iDial)
        }

        binding.btnemail.setOnClickListener {
            val emailIntent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("a@gmail.com","b@gmail.com","r@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT,"Hiring Here!")
                putExtra(Intent.EXTRA_TEXT,"Message here!")
            }
            startActivity(emailIntent)
        }
        binding.btnmessage.setOnClickListener{
            val msgIntent = Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse("sms:9414696844")
                putExtra("sms_body","Message here!")
            }
            startActivity(msgIntent)
        }
        binding.btnshare.setOnClickListener {
            val iShare = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT,"sharing message here!")
            }
            startActivity(Intent.createChooser(iShare,"share via"))
        }
    }
}