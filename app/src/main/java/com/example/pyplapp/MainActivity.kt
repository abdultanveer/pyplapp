package com.example.pyplapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pyplapp.kotlinexs.Employee

class MainActivity : AppCompatActivity() {
    lateinit var mainTextView: TextView
    lateinit var phnoEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)//layout inflation
        mainTextView = findViewById(R.id.tvMain)
        phnoEditText = findViewById(R.id.etPhoneno)

        var myEmmplyee = Employee("ename")

    }

    fun clickHandler(view: View) {
        var phnno = phnoEditText.text.toString()
        mainTextView.setText(phnno)
    }
}