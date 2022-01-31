package com.caesar_code.qr_app

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.caesar_code.qr_app.qr_lib.QRGEncoder
import com.caesar_code.qr_app.qr_lib.QRGContents
import com.google.zxing.WriterException

class GenActivity : AppCompatActivity() {
    private var imageView: ImageView? = null

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gen)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        imageView = findViewById(R.id.imageView)
        val editText = findViewById<EditText>(R.id.editText)

        val scanningBtn: Button = findViewById(R.id.scanning)
        scanningBtn.setOnClickListener{
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        val createBtn: Button = findViewById(R.id.create)
        //OnEditorActionListener - срабатывает при нажатии Enter и при других команд редактирования, но не срабатывает на ввод обычных символов.
        createBtn.setOnClickListener{
            val text: String = editText.text.toString()
            generateQrCode(text)
            Toast.makeText(applicationContext, text, Toast.LENGTH_LONG).show()
        }

    }
    private fun generateQrCode(text: String){
        val qrGenerator = QRGEncoder(text, null, QRGContents.Type.TEXT, 800)
        try {
            val bMap = qrGenerator.bitmap
            imageView?.setImageBitmap(bMap)
        } catch (e: WriterException){

        }
    }
}