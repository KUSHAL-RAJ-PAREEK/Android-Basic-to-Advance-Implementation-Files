package com.goodhub.myfamily

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity



class SplashScreen: AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        SharedPref.init(this)

      val isUserLoggedIn =  SharedPref.getBoolean(PrefConstants.IS_USER_LOGGED_IN)
        if(isUserLoggedIn){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }else{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }


    }
}