package com.krp.lottieanimationsample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krp.lottieanimationsample.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnplay.setOnClickListener {
            binding.laView.setAnimation(R.raw.mobile_ui)
            binding.laView.repeatCount = 1000
            binding.laView.playAnimation()
        }
    }
}