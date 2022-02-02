package com.caesar_code.qr_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView


class ScanActivity : AppCompatActivity(), ZXingScannerView.ResultHandler {
    private lateinit var zbView: ZXingScannerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        zbView = ZXingScannerView(this)
        setContentView(zbView)
    }

    override fun onResume() {
        super.onResume()
        zbView.setResultHandler(this)
        zbView.startCamera()
    }

    override fun onPause() {
        super.onPause()
        zbView.stopCamera()
    }

    override fun handleResult(p0: Result?) {
        //Log.d("MyLog", "Result:${Result?.contents}")
        finish()
    }

}