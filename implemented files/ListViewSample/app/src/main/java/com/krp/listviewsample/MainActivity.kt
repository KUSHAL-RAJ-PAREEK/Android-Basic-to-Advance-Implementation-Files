package com.krp.listviewsample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.krp.listviewsample.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val arrGender = arrayListOf<String>().apply {
//            add("Female")
//            add("Male")
//            add("Other")
//        }
        val arrNames = arrayListOf<String>().apply {

            add("Krishna")
            add("Ram")
            add("Narayan")
            add("Govind")
            add("Hari")
            add("Krishna")
            add("Ram")
            add("Narayan")
            add("Govind")
            add("Hari")
            add("Krishna")
            add("Ram")
            add("Narayan")
            add("Govind")
            add("Hari")
            add("Krishna")
            add("Ram")
            add("Narayan")
            add("Govind")
            add("Hari")
            add("Krishna")
            add("Ram")
            add("Narayan")
            add("Govind")
            add("Hari")
        }

//        binding.listView.apply {
//            adapter = ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,arrNames)
//            setOnItemClickListener { parent, view, position, id ->
//
//                when(position){
//
//                    0 -> {
//                        Toast.makeText(this@MainActivity,"First item clicked!",Toast.LENGTH_SHORT).show()
//
//                    }
//
//                    1 -> {
//                        Toast.makeText(this@MainActivity,"Second item clicked!",Toast.LENGTH_SHORT).show()
//                    }
//
//                    2 ->{
//                        Toast.makeText(this@MainActivity,"Third item clicked!",Toast.LENGTH_SHORT).show()
//                    }
//                }
//        }
//
//        }

//        binding.spinner.adapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,arrGender)
//
//        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//               if(position == 0){
//                   Toast.makeText(this@MainActivity,"Female is selected",Toast.LENGTH_SHORT).show()
//               }
//                if(position == 1){
//                    Toast.makeText(this@MainActivity,"Male is selected",Toast.LENGTH_SHORT).show()
//                }
//                if (position == 2){
//                    Toast.makeText(this@MainActivity,"Other is selected",Toast.LENGTH_SHORT).show()
//                }
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                Toast.makeText(this@MainActivity,"Nothing is selected",Toast.LENGTH_SHORT).show()
//            }
//
//        }

        binding.actView.setAdapter( ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,arrNames))
        binding.actView.threshold = 3
    }
}