package com.expleo.contactdemo

import android.Manifest
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.expleo.androidkotlintutorial.adapter.ContactAdapter
import com.expleo.contactdemo.model.Contact


class MainActivity : AppCompatActivity() {

    var recyclerView: RecyclerView? = null

    var listAllContacts = ArrayList<Contact>()
    var listContact = ArrayList<Contact>()
    var adapter: ContactAdapter? = null
    var cursor: Cursor? = null
    var name: String? = null
    var phonenumber:String? = null
    val RequestPermissionCode = 1
    var sharedPreferences : SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycleContact)
        recyclerView!!.layoutManager = LinearLayoutManager(this)

        sharedPreferences = this.getSharedPreferences("contacts", Context.MODE_PRIVATE)
    }

    override fun onResume() {
        super.onResume()

        var allowed = sharedPreferences!!.getBoolean("allowed", false)
        if (allowed) {
            getSingleContactList()
        } else {
            enableRuntimePermission()
        }
    }


    fun enableRuntimePermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.READ_CONTACTS
            )
        ) {
            Toast.makeText(
                this,
                "CONTACTS permission allows us to Access CONTACTS app",
                Toast.LENGTH_LONG
            ).show()
        } else {
            ActivityCompat.requestPermissions(
                this, arrayOf(
                    Manifest.permission.READ_CONTACTS
                ), RequestPermissionCode
            )
        }
    }

    fun getAllContactsList() : ArrayList<Contact> {

        listAllContacts = ArrayList<Contact>()
//        cursor = contentResolver.query(
//            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//            null,
//            null,
//            null,
//            null
//        )
//        while (cursor!!.moveToNext()) {
//            name =
//                cursor!!.getString(cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME ))
//            phonenumber =
//                cursor!!.getString(cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
//            var contact = Contact()
//            contact.name = name
//            contact.number = phonenumber
//            listAllContacts.add(contact)
//        }
//        cursor!!.close()
//        adapter = ContactAdapter(listAllContacts)
//        recyclerView!!.adapter = adapter

        var contact1 = Contact()
        contact1.name = "Senthil"
        contact1.number = "9878787878"
        listAllContacts.add(contact1)

        var contact2 = Contact()
        contact2.name = "Dhayalu"
        contact2.number = "9878787878"
        listAllContacts.add(contact2)

        var contact3 = Contact()
        contact3.name = "Gowtham"
        contact3.number = "9878787878"
        listAllContacts.add(contact3)

        return listAllContacts
    }

    fun getSingleContactList() : ArrayList<Contact> {

        listContact = ArrayList<Contact>()
//        cursor = contentResolver.query(
//            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
//            null,
//            null,
//            null,
//            null
//        )
//        while (cursor!!.moveToNext()) {
//            name =
//                cursor!!.getString(cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME ))
//            phonenumber =
//                cursor!!.getString(cursor!!.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
//            var contact = Contact()
//
//            if (phonenumber.toString().contains("8869")) {
//                contact.name = name
//                contact.number = phonenumber
//                listContact.add(contact)
//            }
//        }
//        cursor!!.close()
//        adapter = ContactAdapter(listContact)
//        recyclerView!!.adapter = adapter


          var contact1 = Contact()
          contact1.name = "Senthil"
          contact1.number = "9878787878"
          listContact.add(contact1)
//        for (contact in listContact) {
//
//            Log.d("Single Contact", "Name :" + contact.name)
//            Log.d("Single Contact", "Number :" + contact.number)
//
//        }

        return listContact
    }



    // callback methods

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            RequestPermissionCode -> if (grantResults.size > 0 && grantResults.get(0) === PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(
                    this,
                    "Permission Granted, Now your application can access CONTACTS.",
                    Toast.LENGTH_LONG
                ).show()

                var editor = sharedPreferences!!.edit()
                editor.putBoolean("allowed", true)
                editor.commit()
                getAllContactsList()
            } else {
                Toast.makeText(
                    this,
                    "Permission Canceled, Now your application cannot access CONTACTS.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }



}
