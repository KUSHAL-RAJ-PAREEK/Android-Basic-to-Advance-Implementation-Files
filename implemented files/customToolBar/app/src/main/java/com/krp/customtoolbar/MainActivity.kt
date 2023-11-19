package com.krp.customtoolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.krp.customtoolbar.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolBar)

        binding.toolBar.apply {
            title = "My Toolbar"
            subtitle = "Sub Text"
        }
        supportActionBar!!.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowTitleEnabled(false)
        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.menu_settings -> {
                Toast.makeText(this,"Setting Opened!",Toast.LENGTH_SHORT).show()
            }
            R.id.menu_create -> {
                Toast.makeText(this,"Created!",Toast.LENGTH_SHORT).show()
            }
            R.id.menu_save -> {
                Toast.makeText(this,"Saved!",Toast.LENGTH_SHORT).show()
            }
            R.id.menu_close -> {
                Toast.makeText(this,"Closed!",Toast.LENGTH_SHORT).show()
            }
            android.R.id.home -> {
                onBackPressed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}