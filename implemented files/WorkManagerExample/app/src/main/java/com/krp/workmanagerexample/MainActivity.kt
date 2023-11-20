package com.krp.workmanagerexample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.krp.workmanagerexample.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val myWorkerRequest = OneTimeWorkRequest.Builder(MyWorker::class.java).build()

        binding.btnStartTask.setOnClickListener {
            WorkManager.getInstance(this).enqueue(myWorkerRequest)
        }

        WorkManager.getInstance(this)
            .getWorkInfoByIdLiveData(myWorkerRequest.id).observe(this) {workInfo->

                binding.txtStatus.append("${workInfo.state.name} \n")

            }
    }
}


