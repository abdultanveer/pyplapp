package com.example.pyplapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pyplapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
       val view = binding.root
        setContentView(view)
     //   setContentView(R.layout.activity_main)

    }

    override fun onPause() {
        super.onPause()
        storeData()
    }

    private fun storeData() {
       //get the data from the edittexts
        var title = binding.etTitle.text.toString()
        var desc = binding.etSubtitle.text.toString()
        //create a file
        var sharedprefs = getSharedPreferences("pyplfile", MODE_PRIVATE)
        //open the file in edit mmode
        var editor = sharedprefs.edit()
        //write to the file
        editor.putString("title",title)
        editor.putString("desc",desc)
        //save the file
        editor.apply()
    }
//data/data/com.example.pypl/shared_prefs/filename.xml
    override fun onResume() {
        super.onResume()
        restoreData()
    }

    private fun restoreData() {

        //read the data from the file
        var sharedprefs = getSharedPreferences("pyplfile", MODE_PRIVATE)
        //set the data back innto edittexts
        var title = sharedprefs.getString("title","")
        var desc = sharedprefs.getString("desc","")

        binding.etTitle.setText(title)
        binding.etSubtitle.setText(desc)
    }
}