package com.krp.bmi


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.krp.bmi.databinding.ActivityMainBinding
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // BMI = Body Mass Index  person (Wt : Ht)
        // bmi = wt/(ht*ht) -> kg/m^2
        val btnCalculate = this.findViewById<Button>(R.id.btnCalculate)
        val edtWeight = findViewById<EditText>(R.id.edtWeight)
        val edtHeightft = findViewById<EditText>(R.id.edtHeightft)
        val edtHeigtin = findViewById<EditText>(R.id.edtHeigtin)
        val txtResult = findViewById<TextView>(R.id.txtResult)

           btnCalculate.setOnClickListener {
               if (edtWeight.text.toString() != "" &&
                   edtHeightft.text.toString() != "" &&
                   edtHeigtin.text.toString() != ""){
                   val wt = edtWeight.text.toString().toInt()
                   val htFt = edtHeightft.text.toString().toInt()
                   val htIn = edtHeigtin.text.toString().toInt()

                   val totalIn = htFt * 12 + htIn

                   // i inch = 2.54 cm

                   val htCm = totalIn * 2.54

                   // 1m = 100cm
                   // 1cm /100m

                   val htM = htCm/100

                   val bmi = wt/(htM*htM)

                   when {
                       bmi > 25 -> {
                           txtResult.text = "You're OverWeight!"
                       }
                       bmi < 18 -> {
                           txtResult.text = "You're UnderWeight!"
                       }
                       else -> {
                           txtResult.text = "You're Healthy!"
                       }
                   }
               } else{
                   Toast.makeText(this,"please fill up all the required blanks",Toast.LENGTH_LONG).show()
               }


        }
    }
}