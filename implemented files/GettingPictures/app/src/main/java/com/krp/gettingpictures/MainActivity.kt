package com.krp.gettingpictures

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import com.krp.gettingpictures.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val launcherCam = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {result ->
            if(result.resultCode == RESULT_OK){
                val image = result.data!!.extras!!.get("data") as Bitmap
                binding.imgMain.setImageBitmap(image)
            }
        }
        binding.btnCamera.setOnClickListener {

            val iCam = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            launcherCam.launch(iCam)
        }
        val launchGallery = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){ result->

            if(result.resultCode == RESULT_OK){
               binding.imgMain.setImageBitmap(MediaStore.Images.Media.getBitmap(applicationContext.contentResolver,result.data!!.data))

            }

        }

        binding.btnGallery.setOnClickListener {
            val iGallery = Intent(Intent.ACTION_GET_CONTENT).setType("images/*")
            launchGallery.launch(iGallery)
        }
    }
}