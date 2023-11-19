package com.krp.tabsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krp.tabsample.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.viewPager.adapter = ViewPagerAdapter(supportFragmentManager)

        binding.TabLayout.setupWithViewPager(binding.viewPager)

    }
}