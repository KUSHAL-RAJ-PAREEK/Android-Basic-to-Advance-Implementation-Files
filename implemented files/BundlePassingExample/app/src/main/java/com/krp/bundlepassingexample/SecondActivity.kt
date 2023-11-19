package com.krp.bundlepassingexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.krp.bundlepassingexample.databinding.ActivityMainBinding
import com.krp.bundlepassingexample.databinding.ActivitySecondBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val name = intent .getStringExtra("Name")
        val flag = intent.getIntExtra("Flag",0)

        binding.txtWelcome.text = "Welcome, $name"
        Toast.makeText(this,"The flag value is: $flag",Toast.LENGTH_SHORT).show()
    }
}