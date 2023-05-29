package com.example.sensitivedatasaver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import com.example.sensitivedatasaver.data.DatabaseHelper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    lateinit var handler: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        handler = DatabaseHelper(this)

        val login = findViewById<EditText>(R.id.usernameText)
        val password = findViewById<EditText>(R.id.passwdText)

        val registerBtn = findViewById<Button>(R.id.registerBtn)
        registerBtn.setOnClickListener {
            println(login.text.toString())
            println(password.text.toString())
            handler.insertUserData(login.text.toString(), password.text.toString())
        }
    }
}