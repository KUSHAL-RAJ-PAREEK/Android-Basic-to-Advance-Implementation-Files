package com.krp.recyclerviewsample

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.dialog_add_update.btnAdd
import kotlinx.android.synthetic.main.dialog_add_update.btnCancel
import kotlinx.android.synthetic.main.dialog_add_update.edtName
import kotlinx.android.synthetic.main.dialog_add_update.edtNumber
import kotlinx.android.synthetic.main.dialog_add_update.txtTitle

class RecyclerContactAdapter(val context: Context, val arrData : ArrayList<ContactModel>) : RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder>(){

    class ViewHolder(view: View, view2: View): RecyclerView.ViewHolder(view){

        val imgContact = view?.findViewById<ImageView>(R.id.imgContact)
        val txtName = view?.findViewById<TextView>(R.id.txtContactName)
        val txtNo = view?.findViewById<TextView>(R.id.txtContactName)
        val rootview = view?.findViewById<CardView>(R.id.rootview)

        val txtTitle=view2.findViewById<TextView>(R.id.txtTitle)
        val edtName=view2.findViewById<EditText>(R.id.edtName)
        val edtNumber=view2.findViewById<EditText>(R.id.edtNumber)
        val btnAdd=view2?.findViewById<Button>(R.id.btnAdd)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false)
        val view2 = LayoutInflater.from(context).inflate(R.layout.dialog_add_update,parent,false)

       // if()
        return ViewHolder(view,view2)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = arrData[position]
        holder.imgContact?.setImageResource(model.img)
        holder.txtName?.text = model.name
        holder.txtNo?.text = model.no

        AnimatorSet().apply {
            playTogether(
                ObjectAnimator.ofFloat(holder.rootview,View.ALPHA,0f,1f).apply{
                    duration = 700
                },
                        ObjectAnimator.ofFloat(holder.rootview,View.TRANSLATION_X,500f,0f).apply{
                duration = 700
            }

            )
            start()
        }
        holder.rootview.setOnClickListener{

            Log.d("Pos","position is: $position")


            Dialog(context).apply {

                setContentView(R.layout.dialog_add_update)

                holder.txtTitle.text = "Update Contact"
                holder.edtName.setText(arrData[position].name)
                holder.edtNumber.setText(arrData[position].no)
                holder.btnAdd.text = "Save"

                holder.btnAdd.setOnClickListener {
                    arrData[position] = ContactModel(
                        arrData[position].img,
                        holder.edtName.text.toString(),
                        holder.edtNumber.text.toString()
                    )

                    notifyItemChanged(position)
                    dismiss()
                }
                this.btnCancel.setOnClickListener {
                    dismiss()
                }
                show()

            }
        }

        holder.rootview.setOnLongClickListener {
            AlertDialog.Builder(context).apply {
                setMessage("Are you sure want to delete contact?")
                setPositiveButton("yes"
                ) { dialog, which ->
                    arrData.removeAt(position)
                    notifyItemRemoved(position)
                }
                setNegativeButton("No") { dialog, which ->


                }
                show()
            }

            true
        }
    }
    override fun getItemCount(): Int {
        return arrData.size
    }

}