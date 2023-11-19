package com.krp.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.krp.livedataexample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.btnStart
import kotlinx.android.synthetic.main.activity_main.btnStop
import kotlinx.android.synthetic.main.activity_main.edtCount
import kotlinx.android.synthetic.main.activity_main.txrCount

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(
            this,R.layout.activity_main)

        binding.lifecycleOwner = this
        val mAViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.myViewModel = mAViewModel

        mAViewModel.startTime()
        mAViewModel._second.observe(this, Observer { second ->
            binding.txrCount.text = "$second"
        })
        mAViewModel.finidhed.observe(this,Observer{ check->
            if(check){
                Toast.makeText(this,"Timer completed",Toast.LENGTH_SHORT).show()
            }
        })

        btnStart.setOnClickListener {
            if(edtCount.text.isEmpty()){
                Toast.makeText(this,"please fill the time for Counter",Toast.LENGTH_SHORT).show()
                } else{
                    mAViewModel.timerVlaue.value = edtCount.text.toString().toLong()*1000
                mAViewModel.startTime()
            }

            btnStop.setOnClickListener {
                mAViewModel.stopTime()
            }
        }
    }
}