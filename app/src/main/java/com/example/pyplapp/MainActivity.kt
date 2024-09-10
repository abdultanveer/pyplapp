package com.example.pyplapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var TAG = MainActivity::class.java.simpleName
    lateinit var btnHome:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btnHome = findViewById(R.id.btnHome)
        Log.i(TAG,"created -my allocated")

    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG,"activity is visible-hatched-started")
        btnHome.setOnClickListener {
            var homeIntent = Intent(this,HomeActivity::class.java)
            startActivity(homeIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.e(TAG,"activity resumed-awake")

    }

    override fun onPause() {
        super.onPause()
        Log.w(TAG,"activity paused-sleep")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"activity stopped-hibernate")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG,"activity destroyed")

    }



}