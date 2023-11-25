package com.krp.bannerandinterstitialads

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.krp.bannerandinterstitialads.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
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
        val showinteradsbtn = findViewById<Button>(R.id.ibutton)

        val myinterstitialAds = MyInterstitialAds(this)
        myinterstitialAds.loadInterstitialAds(R.string.interAdUnitID)
        showinteradsbtn.setOnClickListener {
            myinterstitialAds.showInterstitialAds {

                // here interstitial finish or diminishes or not load after execute
                val afterIntenet = Intent(this,AfterinterstitialFinishedActitvity::class.java)
                startActivity(afterIntenet)

            }
        }

        val showNativeAds = findViewById<Button>(R.id.nbutton)
        showNativeAds.setOnClickListener {

            val smallMediumIntent = Intent(this,NativeAdsActivity::class.java)
            startActivity(smallMediumIntent)
        }
    }
}
