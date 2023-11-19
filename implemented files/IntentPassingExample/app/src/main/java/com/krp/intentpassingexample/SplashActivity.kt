package com.krp.intentpassingexample
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.WindowManager.*
import com.krp.intentpassingexample.databinding.ActivityMainBinding
import com.krp.intentpassingexample.databinding.ActivitySplashBinding

@SuppressLint("StaticFieldLeak")
lateinit var binding: ActivitySplashBinding
@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_splash)
        window.setFlags(
            LayoutParams.FLAG_FULLSCREEN,
            LayoutParams.FLAG_FULLSCREEN)
        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
        finish()
                              },4000)
    }
}