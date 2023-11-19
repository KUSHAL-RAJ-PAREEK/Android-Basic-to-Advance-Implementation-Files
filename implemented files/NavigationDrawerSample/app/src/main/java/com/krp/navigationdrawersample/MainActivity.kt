package com.krp.navigationdrawersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.krp.navigationdrawersample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.drawer_lay
import kotlinx.android.synthetic.main.activity_main.navigationView
import kotlinx.android.synthetic.main.bar_main.toolbar

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(toolbar)

        val actionToggle = ActionBarDrawerToggle(
            this, drawer_lay, toolbar, R.string.OpenNavigationDrawer, R.string.closeNavigationDrawer
        )
        drawer_lay.addDrawerListener(actionToggle)
        actionToggle.syncState()


        navigationView.setNavigationItemSelectedListener { menuItem ->

            val id = menuItem.itemId

            when (id) {
                R.id.drawer_opt_home -> {
                    loadFrag(HomeFragment())
                }
                R.id.drawer_opt_setting -> {
                    loadFrag(GalleryFragment())
                }
                else -> {
                    loadFrag(SettingFragment())
                }
            }

            drawer_lay.closeDrawer(GravityCompat.START)



            true
        }
    }

    private fun loadFrag(fragment: Fragment) {
        supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
    }

    override fun onBackPressed() {
        if(drawer_lay.isDrawerOpen(GravityCompat.START)){
            drawer_lay.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
}