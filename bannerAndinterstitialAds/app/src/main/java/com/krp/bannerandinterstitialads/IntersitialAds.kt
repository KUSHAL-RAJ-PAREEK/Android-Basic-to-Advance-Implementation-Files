package com.krp.bannerandinterstitialads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

var interstitialAd : InterstitialAd? = null
class IntersitialAds : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intersitial_ads)

        //Interstitial Ads
        MobileAds.initialize(
            this
        ) { Log.d("Mobile Ads Initialization", "completed") }

        val interAdRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,
            getString(R.string.interAdUnitID),
            interAdRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                    Log.d("InterAdIndo", "Ad Failed to Load $p0")
                }

                override fun onAdLoaded(interAd: InterstitialAd) {
                    super.onAdLoaded(interAd)
                    interstitialAd = interAd
                    interstitialAd!!.show(this@IntersitialAds)

                    interstitialAd!!.fullScreenContentCallback = object : FullScreenContentCallback(){

                        override fun onAdShowedFullScreenContent() {
                            super.onAdShowedFullScreenContent()
                            interstitialAd = null
                        }

                        override fun onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent()
                            Log.d("InterInfo","Ad Dismissed!")
                        }

                        override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                            super.onAdFailedToShowFullScreenContent(p0)
                            Log.d("InterInfo","Ad Failed to show..$p0!")
                        }
                    }

                }

            })
    }
}