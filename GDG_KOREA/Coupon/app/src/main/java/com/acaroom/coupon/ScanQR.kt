package com.acaroom.coupon

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator


class ScanQR : AppCompatActivity() {

    private var qrScan: IntentIntegrator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_q_r)

        qrScan = IntentIntegrator(this)
        qrScan!!.setOrientationLocked(false) // default가 세로모드인데 휴대폰 방향에 따라 가로, 세로로 자동 변경됩니다.
        qrScan!!.setPrompt("Sample Text!")
        qrScan!!.initiateScan()

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
                val intent = Intent(this@ScanQR, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
                val intent = Intent(this@ScanQR, MainActivity::class.java)
                startActivity(intent)
            }

        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}