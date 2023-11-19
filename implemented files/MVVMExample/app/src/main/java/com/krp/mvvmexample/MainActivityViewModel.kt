package com.krp.mvvmexample

import androidx.lifecycle.ViewModel

class MainActivityViewModel(private val name: String) : ViewModel() {

    var count = 0
    
    fun increaseCount(){
        count++;
    }


}