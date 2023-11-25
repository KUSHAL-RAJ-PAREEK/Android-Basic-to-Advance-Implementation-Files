package com.krp.adswithmeson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krp.adswithmeson.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

private lateinit var viewModel: MainActivityViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel = MainActivityViewModel(this)
        binding.openBannerAdButton.setOnClickListener {
            viewModel.openBannerAdActivity()
        }

        binding.openNativeAdButton.setOnClickListener {
            viewModel.openNativeAdActivity()
        }

        binding.openInterstitialAdButton.setOnClickListener {
            viewModel.openInterstitialAdActivity()
        }


    }
}