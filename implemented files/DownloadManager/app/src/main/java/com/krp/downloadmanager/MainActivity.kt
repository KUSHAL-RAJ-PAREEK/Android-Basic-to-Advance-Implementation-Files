package com.krp.downloadmanager

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.telephony.mbms.MbmsErrors.DownloadErrors
import com.krp.downloadmanager.databinding.ActivityMainBinding
import java.util.Calendar

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val dm = getSystemService(DOWNLOAD_SERVICE) as DownloadManager

        binding.btnDownload.setOnClickListener {

            val fileName = "Narayan_only_one${Calendar.getInstance().timeInMillis}"
            val downloadUrl = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/a363f8a4-4455-4645-bff9-cfa7e8245acc/d99rzhe-00e53b63-91d5-422f-918a-6ed6fe8f0887.gif/v1/fill/w_650,h_566,q_85,strp/shri_vishnu_narayan_by_vishnu108_d99rzhe-fullview.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9NTY2IiwicGF0aCI6IlwvZlwvYTM2M2Y4YTQtNDQ1NS00NjQ1LWJmZjktY2ZhN2U4MjQ1YWNjXC9kOTlyemhlLTAwZTUzYjYzLTkxZDUtNDIyZi05MThhLTZlZDZmZThmMDg4Ny5naWYiLCJ3aWR0aCI6Ijw9NjUwIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLm9wZXJhdGlvbnMiXX0.EPOu__2Rfh1CEsABbZTiDZvNFkEcHG8UPGhPD3-yeIs"
        val downloadRequest = DownloadManager.Request(Uri.parse(downloadUrl)).apply {
            title = "Download"
            setDescription("Downloading Image")
            setDestinationInExternalFilesDir(this@MainActivity,Environment.DIRECTORY_DOWNLOADS,fileName)
            setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        }

            dm.enqueue(downloadRequest)

        }
    }
}