package com.krp.databaseexample

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build.MODEL
import android.provider.Contacts.SettingsColumns.KEY

class MyDataBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,
    DATABASE_VERSION){

    companion object{
        private val DATABASE_NAME = "User"
        private val DATABASE_VERSION = 1
        private val CONTACT_TABLE = "contacts"
        private  val KEY_ID = "id"
        private val KEY_NAME = "name"
        private val KEY_NO = "no"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(
            "Create table $CONTACT_TABLE($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    " $KEY_NAME TEXT,"+
                    " $KEY_NO TEXT)"
        )



    }

    fun openDB(){
        val db = this.readableDatabase
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $CONTACT_TABLE")
        onCreate(db)
    }
    fun addContact(contact : ContactModel){

        val db = this.writableDatabase

        val cv = ContentValues()

        cv.put(KEY_ID, contact.id)
        cv.put(KEY_NAME, contact.name)
        cv.put(KEY_NO, contact.no)



        db.insert(CONTACT_TABLE,null, cv)

//        db.close()

    }
    fun getAllContacts(): ArrayList<ContactModel>{

        val db = this.readableDatabase

       val cursor =  db.rawQuery("SELECT *  from $CONTACT_TABLE",null)
        val arrContact = ArrayList<ContactModel>()
        while(cursor.moveToNext()){

            val id = cursor.getInt(0)
            val name = cursor.getString(1)
            val no = cursor.getString(2)

            arrContact.add(ContactModel(id,name,no))

        }

        cursor.close()
//        db.close()

        return arrContact

    }

    fun updateContact(model: ContactModel){

        val db = this.writableDatabase

        val cv = ContentValues()
        cv.put(KEY_NAME,model.name)
        cv.put(KEY_NO,model.no)
        db.update(CONTACT_TABLE,cv,"$KEY_ID = ${model.id}",null)

//        db.close()
    }
    fun deleteContact(id : Int){

        val db = this.writableDatabase

        db.delete(CONTACT_TABLE,"$KEY_ID = ?", arrayOf(id.toString()))
        db.close()
    }


}