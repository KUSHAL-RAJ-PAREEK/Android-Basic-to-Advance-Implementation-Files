package com.krp.adswithmeson

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel

class MainActivityViewModel(private val context: Context) : ViewModel() {

    fun openBannerAdActivity() {
        navigateToActivity(bannerAds::class.java)
    }

    fun openNativeAdActivity() {
        navigateToActivity(NativeAds::class.java)
    }

    fun openInterstitialAdActivity() {
        navigateToActivity(InterstitialAds::class.java)
    }

    private fun navigateToActivity(activityClass: Class<*>) {
        val intent = Intent(context, activityClass)
        context.startActivity(intent)
    }
}