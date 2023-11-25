package com.krp.adswithmeson

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import ai.meson.Meson
import ai.meson.MesonSdkConfiguration


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Meson.initialize(this)
        //0fb06e57-f40b-4f42-bc2c-441217be655b
    }
}