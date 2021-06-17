package com.expleo.contactdemo.jsinterface

import android.app.AlertDialog
import android.content.Context
import android.webkit.JavascriptInterface

class DemoInterface (context : Context) {

    var context : Context? = null

    init {

        this.context = context
    }

    @JavascriptInterface
    fun showAlertMsg(name: String , email : String) {

        AlertDialog.Builder(context)
            .setTitle("Demo UI")
            .setMessage("$name " + " " + "$email" )
            .show()
    }

    @JavascriptInterface
    fun getName() : String {

        return "Welcome TO Expleo"
    }

}
