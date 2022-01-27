package com.caesar_code.qr_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GenActivity : AppCompatActivity() {
    var imageView: ImageView? = null
    var Create: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gen)

        imageView = findViewById(R.id.imageView)



        val Scanning: Button = findViewById(R.id.scanning)
        Scanning.setOnClickListener{
            val intent = Intent(this@GenActivity, MainActivity::class.java)
            startActivity(intent)
        }

        val Create: Button = findViewById(R.id.create)
        Create?.setOnClickListener {

        }

        fun generateQrCode(text: String){

        }
    }
}