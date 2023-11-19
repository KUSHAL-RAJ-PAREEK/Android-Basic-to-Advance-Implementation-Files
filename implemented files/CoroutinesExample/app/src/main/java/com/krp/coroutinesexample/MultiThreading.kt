package com.krp.coroutinesexample

import android.content.res.Resources.Theme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MultiThreading {
}


fun main(){
    UITask()
    GlobalScope.launch {
        NetworkCallTask()
    }
    UITask()
    Thread.sleep(3000L)
}

suspend fun NetworkCallTask(){
    delay(2000L)
    withContext(Dispatchers.IO) {
        ("Loading...")
        println("Thread: ${Thread.currentThread().name}")
    }
}

fun UITask(){
    println("Refresh UI...")
    println("Thread: ${Thread.currentThread().name}")
}