package com.example.pyplapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pyplapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//lateinit var  btnnStart:Button
private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnStart.setOnClickListener {
            var serviceIntent = Intent(this,MyService::class.java)
            startService(serviceIntent)

        }

        binding.btnStop.setOnClickListener {
            var serviceIntent = Intent(this,MyService::class.java)
            stopService(serviceIntent)
        }
       // setContentView(R.layout.activity_main)
      /*  btnnStart = findViewById(R.id.btnStart)
        btnnStart.setOnClickListener {
            //start service
        }*/

    }
}