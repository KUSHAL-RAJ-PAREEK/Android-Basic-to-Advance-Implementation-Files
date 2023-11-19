package com.krp.bottomnavigationsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.krp.bottomnavigationsample.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding
@Suppress("UNUSED_EXPRESSION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bnView.setOnNavigationItemReselectedListener{ item->

            val id = item.itemId
            when (id) {
                R.id.nav_home -> {
                    loadFrag(AFragment())
                }
                R.id.nav_Meeting -> {
                    loadFrag(BFragment())
                }
                R.id.nav_explore -> {
                    loadFrag(CFragment())
                }
                R.id.nav_Setting -> {
                    loadFrag(DFragment())
                }
                else -> {
                    loadFrag(EFragment())
                }
            }

            true
        }
        binding.bnView.selectedItemId = R.id.nav_explore
    }
    fun loadFrag(fragment: Fragment){
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.add(R.id.container,fragment)
        ft.commit()
    }
}