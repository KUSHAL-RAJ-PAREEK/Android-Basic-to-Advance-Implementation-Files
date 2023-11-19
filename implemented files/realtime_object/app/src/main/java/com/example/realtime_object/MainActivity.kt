package com.example.realtime_object

import android.Manifest
import android.annotation.SuppressLint
import android.content.AsyncQueryHandler
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.SurfaceTexture
import android.hardware.camera2.CameraDevice
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.HandlerThread
import android.view.Surface
import android.view.TextureView
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import java.util.logging.Handler

class MainActivity : AppCompatActivity() {
    lateinit var CameraDevice : CameraDevice
    lateinit var handler: Handler
    lateinit var cameraManager: CameraManager
    lateinit var textureView: TextureView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        get_permission()

        val handlerThread = HandlerThread("videoThread")
        handler = Handler(handlerThread.looper)

        textureView = findViewById(R.id.textureView)
        textureView.surfaceTextureListener = object:TextureView.SurfaceTextureListener{
            override fun onSurfaceTextureAvailable(
                surface: SurfaceTexture,
                width: Int,
                height: Int
            ) {
               open_camera()
            }

            override fun onSurfaceTextureSizeChanged(
                surface: SurfaceTexture,
                width: Int,
                height: Int
            ) {

            }

            override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
             return false
            }

            override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {

            }
        }

        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
    }


    @SuppressLint("MissingPermission")
    fun open_camera(){
        cameraManager.openCamera(cameraManager.cameraIdList[0],object:CameraDevice.StateCallback(){
            override fun onOpened(camera: CameraDevice) {
                CameraDevice = p0

                var surfaceTexture= textureView.surfaceTexture
                var surface = Surface(surfaceTexture)
            }

            override fun onDisconnected(camera: CameraDevice) {

            }

            override fun onError(camera: CameraDevice, error: Int) {

            }
        }, handler)
    }
    fun get_permission() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(arrayOf(android.Manifest.permission.CAMERA),101)
    }
}

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0] != PackageManager.PERMISSION_GRANTED){
            get_permission()
        }
    }
    }


