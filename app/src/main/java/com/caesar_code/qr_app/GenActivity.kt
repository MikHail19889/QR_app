package com.caesar_code.qr_app

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.caesar_code.qr_app.qr_lib.QRGContents
import com.caesar_code.qr_app.qr_lib.QRGEncoder
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
        editText.setOnClickListener {
            val text: String = editText.text.toString()
            generateQrCode(text)
//            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//            imm.hideSoftInputFromWindow(
//                editText.windowToken,
//                InputMethodManager.HIDE_NOT_ALWAYS
//            )
        }

        val scanningBtn: Button = findViewById(R.id.scanning)
        scanningBtn.setOnClickListener{
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
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