package com.krp.mediaplayerexample

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krp.mediaplayerexample.databinding.ActivityMainBinding
import java.sql.PreparedStatement

@SuppressLint("StaticFieldLeak")
private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

      val mp = MediaPlayer()
        mp.apply {

            val aPath = "android.resource://$packageName/raw/android_11"

            val audioURI = Uri.parse(aPath)

            /*setDataSource(aPath)*/
            setDataSource(this@MainActivity,audioURI)
            prepare()
        }

        binding.btnPlay.setOnClickListener {
            mp.start()
        }

        binding.btnPause.setOnClickListener {
           mp.pause()
        }

        binding.btnStop.setOnClickListener {
            mp.pause()
            mp.seekTo(0)
        }
    }

    override fun onStop() {
        super.onStop()
    }
}