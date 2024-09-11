package com.example.pyplapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.SmsMessage
import android.util.Log


class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Log.i(TAG,"abdul u 've an sms")

        val bundle = intent.extras
        if (bundle != null) {
            val pdus = bundle["pdus"] as Array<Any>?
            val messages: Array<SmsMessage?> = arrayOfNulls<SmsMessage>(pdus!!.size)
            for (i in pdus!!.indices) {
                messages[i] = SmsMessage.createFromPdu(pdus!![i] as ByteArray)
            }
            if (messages.size > -1) {
                Log.i(TAG, "Message recieved: " + messages[0]?.getMessageBody() +"senders phono--"+messages[0]?.originatingAddress)
            }
            var hIntent = Intent(context,HomeActivity::class.java)
            hIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            hIntent.putExtra("pypl",messages[0]?.getMessageBody())
            context.startActivity(hIntent)
        }

    }

    companion object{
        var TAG = SmsReceiver::class.java.simpleName
    }
}