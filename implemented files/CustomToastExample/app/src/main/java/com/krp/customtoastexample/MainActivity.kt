package com.krp.customtoastexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.custom_toast_info.view.txtTittle

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myToast = Toast(this).apply {
            val customView = layoutInflater.inflate(R.layout.custom_toast_info, findViewById(R.id.rootView))

            view = customView

            customView.txtTittle.text = "Message is Changed"


            duration = Toast.LENGTH_LONG

            setGravity(Gravity.CENTER, 0 , 0)
            show()

        }


    }
}