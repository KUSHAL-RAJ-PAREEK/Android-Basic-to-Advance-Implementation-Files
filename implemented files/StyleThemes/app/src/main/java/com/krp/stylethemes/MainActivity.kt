package com.krp.stylethemes

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.krp.stylethemes.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    var flag = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnchangetheme.setOnClickListener {

            if(flag){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                flag = false
                binding.btnchangetheme.text = "Dark Mode"
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                flag = true
                binding.btnchangetheme.text = "Light Mode"
            }
        }

    }
}