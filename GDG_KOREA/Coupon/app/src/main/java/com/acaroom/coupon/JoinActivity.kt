package com.acaroom.coupon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_join1.*

class JoinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join1)

        btn_joining.setOnClickListener() {  // If complete the joining in, intent to Login page, or not
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        btn_cancel.setOnClickListener() {   // Clients don't want joining, go back Login page
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}