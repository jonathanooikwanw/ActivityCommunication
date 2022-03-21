package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goButton : Button = findViewById(R.id.button)

        goButton.setOnClickListener {
            startActivityforAResult()
        }


    }

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            val string :String = data?.getStringExtra("result").toString()
            val sendText : TextView = findViewById(R.id.textOne)
            sendText.text = string
        }
    }

    fun startActivityforAResult(){
        val intent = Intent(this, SecondActivity::class.java)
        resultLauncher.launch(intent)
    }
}