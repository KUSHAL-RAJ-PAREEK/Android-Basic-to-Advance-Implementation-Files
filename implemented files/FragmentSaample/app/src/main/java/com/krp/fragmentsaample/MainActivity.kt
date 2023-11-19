package com.krp.fragmentsaample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.krp.fragmentsaample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var  name : String
    lateinit var binding: ActivityMainBinding

    val ROOT_FRAGMENT_TAG = "root_fragment"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //default
        loadFragment(BFragment(),true)
        binding.btnFragA.setOnClickListener {
//            val aFrag = AFragment()
//            val bundle = Bundle()
//            bundle.putString("Argument1","Raman")
//            bundle.putInt("Argument2",7)
//            aFrag.arguments = bundle

            loadFragment(AFragment.getInstance("Ramanujan",11),false)
        }

        binding.btnFragB.setOnClickListener {
            loadFragment(BFragment(),true)
        }

        binding.btnFragC.setOnClickListener {
            loadFragment(CFragment(),false)
        }
    }
    fun loadFragment(fragment: Fragment,flag: Boolean){
        var fm = supportFragmentManager
        val ft = fm.beginTransaction()

        if(flag){
            ft.add(R.id.container, fragment)
            fm.popBackStack(ROOT_FRAGMENT_TAG,FragmentManager
                .POP_BACK_STACK_INCLUSIVE)
            ft.addToBackStack(ROOT_FRAGMENT_TAG)
        } else{
            ft.replace(R.id.container,fragment)
            ft.addToBackStack(null)
        }

        ft.commit()
    }
    fun fromFrag(name : String){
        this.name = name
        Log.d("inAct","FromFragment: $name")
    }
}