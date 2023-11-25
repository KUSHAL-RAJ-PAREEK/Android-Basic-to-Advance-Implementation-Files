package com.krp.bannerandinterstitialads

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krp.bannerandinterstitialads.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bbutton.setOnClickListener {
            val iNext = Intent(this,BannerAds:: class.java)
            startActivity(iNext)

        }
        binding.ibutton.setOnClickListener {
            val iNext = Intent(this,IntersitialAds:: class.java)
            startActivity(iNext)
        }
    }
}
