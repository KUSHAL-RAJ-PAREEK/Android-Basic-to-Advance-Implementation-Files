package com.krp.livedataexample

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel(){

    lateinit var timer : CountDownTimer

    var timerVlaue = MutableLiveData<Long>()

    private val remaining_seconds = MutableLiveData<Int>()

    private var _finished = MutableLiveData<Boolean>()

    val finidhed : LiveData<Boolean>
        get() = _finished
    val _second: LiveData<Int>
        get() = remaining_seconds

    fun startTime(){
        timer = object: CountDownTimer(timerVlaue.value!!.toLong(),1000){
            override fun onTick(millisUntilFinished: Long) {
                val remainingTime = millisUntilFinished/1000
                remaining_seconds.value = remainingTime.toInt()
            }

            override fun onFinish() {
                _finished.value = true
            }

        }.start()
    }

    fun stopTime(){
        timer.cancel()
    }

}