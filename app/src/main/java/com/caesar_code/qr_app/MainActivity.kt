package com.caesar_code.qr_app

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat



class MainActivity : AppCompatActivity() {
    private lateinit var pLauncher: ActivityResultLauncher<Array<String>>
    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        registerPermissionListener()
        checkCameraPermission()

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
                Toast.makeText(this,"Camera run", Toast.LENGTH_LONG).show()
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
                Toast.makeText(this,"Camera run", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,"Permission denied", Toast.LENGTH_LONG).show()
            }
        }
    }
}