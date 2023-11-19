package com.krp.mvvmexample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.*

class MainActivityViewModelFactory(val name : String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainActivityViewModel::class.java))
            return MainActivityViewModel(name) as T
    }
    throw IllegalArgumentException("ViewModel class not Found!!")
}