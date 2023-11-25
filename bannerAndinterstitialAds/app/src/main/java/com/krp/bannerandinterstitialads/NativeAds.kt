package com.krp.bannerandinterstitialads

import android.media.tv.AdRequest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions

class NativeAds : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_native_ads)

        val adLoader = AdLoader.Builder(this, "ca-app-pub-8090565016080889/6062668862")
            .forNativeAd { nativeAd ->
                // Handle the native ad
                // Create a custom view and populate it with native ad assets
            }
            .withAdListener(object : AdListener() {
                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    // Handle ad loading failure
                }
            })
            .build()


        adLoader.loadAd(AdRequest.Builder().build())
        




    }
}