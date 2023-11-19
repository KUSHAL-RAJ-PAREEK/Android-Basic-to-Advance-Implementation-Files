package com.krp.customdialogsample

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Dialog(this).apply {
            setContentView(R.layout.dialog_info)

            val txtTittle = findViewById<TextView>(R.id.txtTittle)
            val txtMessage = findViewById<TextView>(R.id.txtMessage)

            // run time changes in UI
            txtTittle.text = "Cancled"
            txtMessage.text = "file upload request cancled!"

            show()
        }


    }
}