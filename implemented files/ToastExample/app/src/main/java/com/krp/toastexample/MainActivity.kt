package com.krp.toastexample

import android.annotation.SuppressLint
import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.krp.toastexample.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShow.setOnClickListener {
            showMsg("Message popped again!")
        }
    }
    val showMsg: (String) -> Unit = {msg ->
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }
}