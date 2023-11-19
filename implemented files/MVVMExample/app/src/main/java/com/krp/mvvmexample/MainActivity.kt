package com.krp.mvvmexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.krp.mvvmexample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.btnTap
import kotlinx.android.synthetic.main.activity_main.txtCount

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mAViewModel = ViewModelProvider(this,MainActivityViewModelFactory("Narayan")).get(MainActivityViewModel::class.java)

        txtCount.text = "${mAViewModel.count}"
        btnTap.setOnClickListener {
            mAViewModel.increaseCount()
            txtCount.text = "${mAViewModel.count}"
        }
    }
}