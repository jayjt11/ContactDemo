package com.expleo.contactdemo

import android.Manifest
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.webkit.WebView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.expleo.androidkotlintutorial.adapter.ContactAdapter
import com.expleo.contactdemo.jsinterface.DemoInterface
import com.expleo.contactdemo.model.Contact


class WebActivity : AppCompatActivity() {


    var webView : WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        webView = findViewById(R.id.webView)
        webView!!.settings.javaScriptEnabled = true
        webView!!.addJavascriptInterface(DemoInterface(this), "Demo")
        webView!!.loadUrl("file:///android_asset/demo.html")
    }

    override fun onResume() {
        super.onResume()
        webView!!.loadUrl("file:///android_asset/demo.html")
    }
}
