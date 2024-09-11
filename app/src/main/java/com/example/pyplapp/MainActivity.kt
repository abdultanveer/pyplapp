package com.example.pyplapp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
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
            var homeIntent = Intent(this,HomeActivity::class.java) //explicit intent
            homeIntent.putExtra("pypl","android")
            //startActivity(homeIntent)
            startActivityForResult(homeIntent,123)
           // registerReceiver(SmsReceiver(), IntentFilter("ineed.water"))
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
        /*var dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543")) //implicit intent
        startActivity(dialIntent)*/
        var myIntent = Intent(Intent.ACTION_VIEW,
            Uri.parse("http://google.com"))
        startActivity(myIntent)
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
        var a = 10
        var b = a * 20
       // val bookAuth2 = "Harry Potter" to "J. K. Rowling"

        repeat(5){
          var c =  a * b
        }
        throw NullPointerException("crash demo")

    }

    companion object{
        var TAG = MainActivity::class.java.simpleName

    }

    fun openCalendar(view: View) {
        var calIntent = Intent("ineed.water")
        startActivity(calIntent)
    }

    fun showNotification(view: View) {
        createNotificationChannel()
        val intent = Intent(this, HomeActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

        var builder = NotificationCompat.Builder(this, "CHANNEL_ID")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("textTitle")
            .setContentText("textContent")
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(111,builder.build())
    }


    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is not in the Support Library.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "channel name"
                //getString(R.string.channel_name)
            val descriptionText = "describing the channel"
                //getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANNEL_ID", name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system.
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}