package com.krp.firebaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject

class MainActivity : AppCompatActivity() {

    companion object{
        val USER_COLLECTION = "User_Info"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Firestore Data Add
        val mFirestore = FirebaseFirestore.getInstance()

        mFirestore.collection(USER_COLLECTION)
            .document("Ram")
            .set(User("Ram","Dashrath ji","9829975465","Ayodhya"))
            .addOnSuccessListener {
                Log.d("Data","Successfully User data Inserted")
            }
            .addOnFailureListener{
                Log.e("Data",it.toString())
            }

        //Firestore Data Fetch

        mFirestore.collection(USER_COLLECTION)
            .get()
            .addOnSuccessListener { querySnapshot ->
                //Log.d("Documents", querySnapshot.documents.toString())

                for(document in querySnapshot.documents){

                val userModel = document.toObject(User::class.java)

                    userModel!!.let {
                        Log.d("UserDetails","Name : ${userModel.name}, FName: ${userModel.FName}, MobNo: ${userModel.mobNo}, Address: ${userModel.address}")
                    }



                }
            }

    }
}