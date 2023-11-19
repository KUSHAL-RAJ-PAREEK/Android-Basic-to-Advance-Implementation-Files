package com.krp.animationsample

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.google.android.material.animation.AnimatorSetCompat.playTogether
import com.krp.animationsample.databinding.ActivityMainBinding
import kotlinx.coroutines.NonCancellable.start

lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



//
//        val move = AnimationUtils.loadAnimation(this,R.anim.move)
//
//        binding.btnAnim.animation =  AnimationUtils.loadAnimation(this,R.anim.move)

        AnimatorSet().apply {
//            playTogether(
//                ObjectAnimator.ofFloat(binding.btnAnim, View.SCALE_X,1f,4f).apply {
//                    duration = 4000
//                    repeatCount = ObjectAnimator.INFINITE
//                    repeatMode = ObjectAnimator.REVERSE
//
//                },
//
//                ObjectAnimator.ofFloat(binding.btnAnim,View.SCALE_Y,0f,2f).apply {
//                    duration = 4000
//                    repeatCount = ObjectAnimator.INFINITE
//                    repeatMode = ObjectAnimator.REVERSE
//
//                },
//                    ObjectAnimator.ofFloat(binding.btnAnim,View.ROTATION,0f,2f).apply {
//                        duration = 4000
//                        repeatCount = ObjectAnimator.INFINITE
//                        repeatMode = ObjectAnimator.REVERSE
//
//
//                },
//                ObjectAnimator.ofFloat(binding.btnAnim, View.ROTATION_Y,0f,360f).apply {
//                    duration = 4000
//                    repeatCount = ObjectAnimator.INFINITE
//                    repeatMode = ObjectAnimator.REVERSE
//
//                }
//            )

            play(ObjectAnimator.ofFloat(binding.btnAnim, View.SCALE_X,1f,4f).apply {
                duration = 4000
                repeatCount = 5
                repeatMode = ObjectAnimator.REVERSE
            }
            ).before(ObjectAnimator.ofFloat(binding.btnAnim, View.ROTATION_Y,0f,360f).apply {
                duration = 4000
                repeatCount =5
                repeatMode = ObjectAnimator.REVERSE

            })
            start()
        }



    }
}