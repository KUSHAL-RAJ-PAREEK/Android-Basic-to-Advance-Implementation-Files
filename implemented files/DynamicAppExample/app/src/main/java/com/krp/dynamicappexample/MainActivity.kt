package com.krp.dynamicappexample













import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider.AndroidViewModelFactory(this.application)
            .create(MyActivityViewModel::class.java)

        //viewModel.getPosts()
        viewModel.Login()

    }
}