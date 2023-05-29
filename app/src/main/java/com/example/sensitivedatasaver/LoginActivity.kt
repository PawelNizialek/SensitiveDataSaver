package com.example.sensitivedatasaver

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sensitivedatasaver.data.DatabaseHelper

class LoginActivity : AppCompatActivity() {

    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var shPref = getSharedPreferences("checkbox", MODE_PRIVATE)
        var checkbox = shPref.getString("remember", "")

        println(checkbox)

        if(checkbox.equals("true")){
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }else if(checkbox.equals("false")){

        }

        handler = DatabaseHelper(this)

        val login = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)

        val loginBtn = findViewById<Button>(R.id.login)
        loginBtn.setOnClickListener {
            println(login.text.toString())
            println(password.text.toString())

            val isPresent = handler.isUserPresent(login.text.toString(), password.text.toString())
            println(isPresent)
            if (isPresent){
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
            }

            rememberMeFunctionality()

//            handler.insertUserData(login.text.toString(), password.text.toString())
        }
    }

    fun rememberMeFunctionality(){
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        if(checkBox.isChecked){
            val sharedPref = getSharedPreferences("checkbox", MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("remember", "true")
            editor.apply()
            Toast.makeText(this, "Checked", Toast.LENGTH_SHORT).show()
        }else{
            val sharedPref = getSharedPreferences("checkbox", MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("remember", "false")
            editor.apply()
            Toast.makeText(this, "Unchecked", Toast.LENGTH_SHORT).show()
        }
    }


}