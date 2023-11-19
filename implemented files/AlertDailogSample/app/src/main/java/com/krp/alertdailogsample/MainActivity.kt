package com.krp.alertdailogsample

import android.annotation.SuppressLint
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.krp.alertdailogsample.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDialog = AlertDialog.Builder(this).apply {
            setMessage("Error: Can't Fetch the Data, you're not connected to Internet.")
            setPositiveButton("Okay"
            ) { dialog, which ->
                Toast.makeText(
                    this@MainActivity,
                    "Please connect to Internet",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        myDialog.show()
    }


    override fun onBackPressed() {

        AlertDialog.Builder(this).apply {
            setTitle("Exit?")
            setIcon(R.drawable.baseline_exit_to_app_24)
            setMessage("Are you sure want to exit?")

            setPositiveButton("yes"
            ) { dialog, which ->
                super.onBackPressed()
            }
            setNegativeButton("No") { dialog, which ->
                Toast.makeText(this@MainActivity,"Wwlcome Back!",Toast.LENGTH_LONG).show()
           }

            setNeutralButton("Cancel")  { dialog,which ->

            }
        }.show()
    }
}