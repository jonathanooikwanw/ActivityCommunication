package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        val returnButton : Button = findViewById(R.id.button2)
        returnButton.setOnClickListener {
            returnResult()
        }
    }

    fun returnResult(){
        val editText : EditText = findViewById(R.id.editText)
        val editTextHello:String = editText.text.toString()

        val returnIntent = Intent() //makes an intent
        val returnBundle = Bundle() //creates a new bundle
        returnBundle.putString("result", editTextHello) //puts the key and the size of brush in the bundle
        returnIntent.putExtras(returnBundle) //includes bundle in intent
        setResult(Activity.RESULT_OK, returnIntent) //returns result ok to show activity was successful in obtaining data
        finish()
    }
}
