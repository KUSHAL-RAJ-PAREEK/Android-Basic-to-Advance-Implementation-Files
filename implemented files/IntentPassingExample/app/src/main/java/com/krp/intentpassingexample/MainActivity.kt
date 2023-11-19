package com.krp.intentpassingexample

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val edtName = findViewById<EditText>(R.id.edtName)
        btnNext.setOnClickListener {
            //Intent Passing


            val name = edtName.text.toString()
            val iNext = Intent(this,SecondActivity :: class.java)
                iNext.putExtra("Name",name)
            iNext.putExtra("NameLen",name.length)
            startActivity(iNext)

        }
    }
}