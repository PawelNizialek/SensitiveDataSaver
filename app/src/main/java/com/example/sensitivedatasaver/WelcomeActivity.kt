package com.example.sensitivedatasaver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.sensitivedatasaver.data.DatabaseHelper

class WelcomeActivity : AppCompatActivity() {
    lateinit var handler: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        handler = DatabaseHelper(this)

        val data1 = findViewById<EditText>(R.id.data1)
        val data2 = findViewById<EditText>(R.id.data2)
        val data3 = findViewById<EditText>(R.id.data3)

        val registerBtn = findViewById<Button>(R.id.save)
        registerBtn.setOnClickListener {
            println(data1.text.toString())
            println(data2.text.toString())
            println(data3.text.toString())
//            handler.insertUserData(login.text.toString(), password.text.toString())
        }
    }
}