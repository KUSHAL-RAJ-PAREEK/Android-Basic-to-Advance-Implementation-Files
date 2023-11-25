package com.krp.adswithmeson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ai.meson.MesonAdRequest
import ai.meson.MesonNativeAdView

private lateinit var nativeAdView: MesonNativeAdView
class NativeAds : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_native_ads)

        nativeAdView = findViewById(R.id.nativeAdView)

        val adRequest = MesonAdRequest.Builder().build()
        nativeAdView.loadAd(adRequest)
    }
}