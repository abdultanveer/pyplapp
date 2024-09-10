package com.example.pyplapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
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
            homeIntent.putExtra("pypl","android")
            //startActivity(homeIntent)
            startActivityForResult(homeIntent,123)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //resultcode = nose
        if(requestCode == 123 && resultCode == RESULT_OK) {

            var mainTextView: TextView = findViewById(R.id.tvMain)
            var contact = data?.extras?.getString("con")
            mainTextView.text = contact
        }
    }



    fun openDialer(view: View) {
        var dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543"))
        startActivity(dialIntent)
    }

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
       // if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
       // }
    }

    fun setAlarm(view: View) {
        createAlarm("paypal",11,37)
        throw NullPointerException("crash demo")

    }


}