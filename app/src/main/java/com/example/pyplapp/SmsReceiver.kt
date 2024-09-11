package com.example.pyplapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.i(TAG,"abdul u 've an sms")

    }

    companion object{
        var TAG = SmsReceiver::class.java.simpleName
    }
}