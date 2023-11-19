package com.krp.sharedprefexample

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krp.sharedprefexample.databinding.ActivityLoginBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnLogin.setOnClickListener {

            // when logged in successfully
            val sharedPref = getSharedPreferences("Login", MODE_PRIVATE)
            val editor = sharedPref.edit()

            editor.putBoolean("Check",true)
            editor.apply()

           val iMain = Intent(this,MainActivity::class.java)
            startActivity(iMain)
            finish()
        }
    }
}