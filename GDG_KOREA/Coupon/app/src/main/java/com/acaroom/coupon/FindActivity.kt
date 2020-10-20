package com.acaroom.coupon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_find.*

class FindActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find)

        btn_findingID_Nick.setOnClickListener {
            // DB랑 비교 후 Alert
        }

        btn_findingPW_hint.setOnClickListener {
            // DB랑 비교 후 Alert
        }

        btn_join.setOnClickListener {
            val intent = Intent(this@FindActivity, JoinActivity::class.java)
            startActivity(intent)
        }

        btn_cancel.setOnClickListener {
            val intent = Intent(this@FindActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}