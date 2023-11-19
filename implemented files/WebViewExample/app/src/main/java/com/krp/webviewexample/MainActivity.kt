package com.krp.webviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.krp.webviewexample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    val webView = findViewById<WebView>(R.id.webView)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        webView.apply {
            loadUrl("https://www.google.com")
            webViewClient = object : WebViewClient() {

            }
        }
    }

    override fun onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack()
        }else{
            super.onBackPressed()
        }
    }
}