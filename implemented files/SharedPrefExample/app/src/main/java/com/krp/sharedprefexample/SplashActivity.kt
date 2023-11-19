package com.krp.sharedprefexample

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.krp.sharedprefexample.databinding.ActivityLoginBinding
import com.krp.sharedprefexample.databinding.ActivitySplashBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Handler().postDelayed({ proceedNext() },4000)


    }

    fun proceedNext() {
        val sharedpref = getSharedPreferences("Login", MODE_PRIVATE)

        val check = sharedpref.getBoolean("Check", false)

        lateinit var iNext: Intent


        if (check) {
            iNext = Intent(this, MainActivity::class.java)
        } else {
            iNext = Intent(this, LoginActivity::class.java)
        }

        startActivity(iNext)
        finish()
    }
}