package com.krp.intentpassingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val txtName = findViewById<TextView>(R.id.txtName)
        val name = intent.getStringExtra("Name")
        "Welcome, $name".also { txtName.text = it }

       val length =  intent.getIntExtra("NameLen", 0)
        Toast.makeText(this,"The length of $name is: $length",Toast.LENGTH_LONG).show()
    }
}