package com.caesar_code.qr_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Generator: Button = findViewById(R.id.generator)
        Generator.setOnClickListener{
            val intent = Intent(this@MainActivity, GenActivity::class.java)
            startActivity(intent)
        }
    }
}