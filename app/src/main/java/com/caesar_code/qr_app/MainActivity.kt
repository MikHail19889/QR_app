package com.caesar_code.qr_app

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    private lateinit var pLauncher: ActivityResultLauncher<Array<String>>
    var res: String? = null
    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        registerPermissionListener()
        checkCameraPermission()

        val textView: TextView = findViewById(R.id.textView)
        res = intent.extras?.getString("data").toString()
        if(res == "null"){
            res = "Please scanning QR or Bar code"
        }
        textView.setText(res).toString()

        val scanner: Button = findViewById(R.id.scanner)
        scanner.setOnClickListener {
            val intent = Intent(applicationContext, ScanActivity::class.java)
            startActivity(intent)
        }

        val generator: Button = findViewById(R.id.generator)
        generator.setOnClickListener{
            val intent = Intent(applicationContext, GenActivity::class.java)
            startActivity(intent)
        }
    }

    private fun checkCameraPermission(){
        when (PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            -> {
                //Toast.makeText(this,"Camera run", Toast.LENGTH_LONG).show()
            }
            else -> {
                pLauncher.launch(arrayOf(Manifest.permission.CAMERA))
            }
        }
    }

    private fun registerPermissionListener(){
        pLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()){
            if(it[Manifest.permission.CAMERA] == true){
                //Toast.makeText(this,"Camera run", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,"Camera off", Toast.LENGTH_LONG).show()
            }
        }
    }
}