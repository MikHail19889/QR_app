package com.caesar_code.qr_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val generator: Button = findViewById(R.id.generator)
        generator.setOnClickListener{
            val intent = Intent(applicationContext, GenActivity::class.java)
            startActivity(intent)
        }
    }
}