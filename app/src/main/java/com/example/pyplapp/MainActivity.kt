package com.example.pyplapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.i(TAG,"created -my allocated")

    }

    override fun onStart() {
        super.onStart()
        Log.v(TAG,"activity is visible-hatched-started")
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