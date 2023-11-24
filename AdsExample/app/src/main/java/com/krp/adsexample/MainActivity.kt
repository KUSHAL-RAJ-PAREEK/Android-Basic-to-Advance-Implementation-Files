package com.krp.adsexample

import android.media.tv.AdRequest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.krp.adsexample.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {

    lateinit var interstitialAd : InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        MobileAds.initialize(this
        ) { Log.d("MobileAdsInitialization", "Completed") }


        //Interstitial
        val interAdRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,getString(R.string.interAdUnitID),interAdRequest,
            object : InterstitialAdLoadCallback(){

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                    Log.d("InterAdInfo","Ad Failed to Load $p0")
                }

                override fun onAdLoaded(interAd: InterstitialAd) {
                    super.onAdLoaded(interAd)
                    interstitialAd = interAd
                    interstitialAd!!.show(this@MainActivity)

                    interstitialAd!!.fullScreenContentCallback = object : FullScreenContentCallback(){

                        override fun onAdShowedFullScreenContent() {
                            super.onAdShowedFullScreenContent()
                            interstitialAd = null
                        }

                        override fun onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent()
                            Log.d("InterAdInfo","Ad Failed to Dissmiss")
                        }

                        override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                            super.onAdFailedToShowFullScreenContent(p0)
                            Log.d("InterAdInfo","Ad Failed to Show $p0")
                        }

                    }

                }

            })



        // Banner

        val adRequest = AdRequest.Builder().build()

        binding.bannerAD.loadAd(adRequest)

        binding.bannerAD.adListener = object : AdListener(){
            override fun onAdLoaded() {
                super.onAdLoaded()
                Log.d("ADInfo","Ad Loaded!")
            }

            override fun onAdOpened() {
                super.onAdOpened()
                Log.d("ADInfo","Ad Loaded!")
            }

            override fun onAdClicked() {
                super.onAdClicked()
                Log.d("ADInfo","Ad Clicked!")
            }

            override fun onAdClosed() {
                super.onAdClosed()
                Log.d("ADInfo","Ad Loaded Closed!")
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
                Log.d("ADInfo","Ad Fail to Load..$p0!")
            }

            override fun onAdImpression() {
                super.onAdImpression()
                Log.d("ADInfo","Ad Impression Added!")
            }
        }
    }
}