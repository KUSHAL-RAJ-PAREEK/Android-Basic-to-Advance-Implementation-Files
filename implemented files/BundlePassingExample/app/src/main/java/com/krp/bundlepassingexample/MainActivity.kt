package com.krp.bundlepassingexample

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krp.bundlepassingexample.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnNext.setOnClickListener{

            val name = binding.edtName.text.toString()

            val iNext = Intent(this,SecondActivity::class.java)
            iNext.putExtra("Name",name)
            iNext.putExtra("Flag",7)
            startActivity(iNext)

        }

    }
}