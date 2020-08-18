package com.acaroom.hello

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv = findViewById<TextView>(R.id.tv)
        tv.text = "Hello Kotlin"
        tv2.text = "Hello World"

        val button:Button = findViewById(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            var temp:String?= null
            temp = tv.text.toString()
            tv.text = tv2.text
            tv2.text = temp
        })
    }
}
