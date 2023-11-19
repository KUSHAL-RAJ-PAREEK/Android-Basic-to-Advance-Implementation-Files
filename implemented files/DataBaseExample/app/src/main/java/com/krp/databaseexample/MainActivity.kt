package com.krp.databaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbhelper = MyDataBaseHelper(this)

//        dbhelper.addContact(ContactModel(1,"Hari","9829970775"))
//        dbhelper.addContact(ContactModel(2,"Narayan","15413154"))
//        dbhelper.addContact(ContactModel(3,"Krishna","42165125456"))
//        dbhelper.addContact(ContactModel(4,"Gopal","445198441541"))
//        dbhelper.addContact(ContactModel(5,"Ram","9429970775"))

        //dbhelper.updateContact(ContactModel(5,"Ragunandan","5632665465"))
        dbhelper.deleteContact(1)
       val arrContact =  dbhelper.getAllContacts()

        for(contact in arrContact){

            Log.d("Contact","Id: ${contact.id}, Name: ${contact.name}, No: ${contact.no}")

        }
    }
}