package com.krp.fragmentsaample

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_a.view.txtTitle

class AFragment : Fragment() {

    companion object{

        val ARGUMENT1  = "Argument1"
        val ARGUMENT2  = "Argument2"
        @SuppressLint("SuspiciousIndentation")
        fun getInstance(name : String, no: Int) : AFragment{

            val aFrag = AFragment()
            val bundle = Bundle()
                bundle.putString(ARGUMENT1,name)
            bundle.putInt(ARGUMENT2,no)

            aFrag.arguments = bundle

            return aFrag
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_a, container, false)

        (activity as MainActivity).fromFrag("Kushal")

        requireArguments().let { b->
                val name = b.getString(ARGUMENT1)
                Log.d("Arguments","Name: $name,No: ${b.getInt(ARGUMENT2)}")
                view.txtTitle.text = name
            }




        return view
    }

}