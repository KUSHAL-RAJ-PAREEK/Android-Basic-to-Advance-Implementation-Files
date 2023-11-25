package com.krp.adswithmeson

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
private lateinit var interstitialAd: MesonInterstitialAd
class InterstitialAds : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interstitial_ads)


            interstitialAd = MesonInterstitialAd(this, "43799f65-887b-4654-bf9c-87ad286d9bb4")

            val adRequest = MesonAdRequest.Builder().build()
            interstitialAd.loadAd(adRequest)
        }

        private fun showInterstitialAd() {
            if (interstitialAd.isLoaded) {
                interstitialAd.show()
            }
        }
}