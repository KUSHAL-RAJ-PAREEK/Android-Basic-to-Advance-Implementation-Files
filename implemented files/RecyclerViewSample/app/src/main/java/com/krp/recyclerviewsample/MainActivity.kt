package com.krp.recyclerviewsample

import android.annotation.SuppressLint
import android.app.Dialog
import android.app.ProgressDialog.show
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.krp.recyclerviewsample.databinding.ActivityMainBinding
import com.krp.recyclerviewsample.databinding.ContactRowBinding
import kotlinx.android.synthetic.main.activity_main.recyclerView
import kotlinx.android.synthetic.main.dialog_add_update.btnAdd
import kotlinx.android.synthetic.main.dialog_add_update.btnCancel
import kotlinx.android.synthetic.main.dialog_add_update.edtName
import kotlinx.android.synthetic.main.dialog_add_update.edtNumber

@SuppressLint("StaticFieldLeak")
lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var adapter: RecyclerContactAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         val arrData = arrayListOf<ContactModel>(
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Hari","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Hari","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Hari","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Hari","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Hari","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Hari","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Hari","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Hari","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Hari","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Hari","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Hari","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Hari","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Hari","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Hari","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Hari","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775"),
             ContactModel(R.drawable.krishna,"Hari","9829970775"),
             ContactModel(R.drawable.krishna,"Narayan","9829970775")
         )

        Log.d("ArrSize","Size; ${arrData.size}")

       binding.recyclerView.layoutManager = GridLayoutManager(this,2)
        adapter = RecyclerContactAdapter(this,arrData)
        binding.recyclerView.adapter = adapter

        binding.fabAdd.setOnClickListener{
            Dialog(this).apply {
                setContentView(R.layout.dialog_add_update)
               this.btnAdd.setOnClickListener {

                   if (this.edtName.text.toString() != "" && this.edtNumber.text.toString() != "") {
                       arrData.add(
                           ContactModel(
                               R.drawable.krishna,
                               this.edtName.text.toString(),
                               this.edtNumber.text.toString()
                           )
                       )
                       adapter.notifyItemInserted(arrData.size - 1)
                       dismiss()
                   }else{
                       Toast.makeText(this@MainActivity,"please fill all required blanks!",Toast.LENGTH_LONG).show()
                   }
               }
                this.btnCancel.setOnClickListener {
                    dismiss()
                }

                show()
            }
        }

    }
}